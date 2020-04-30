package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class AddProduct extends AppCompatActivity {

    Button insert;

    Button get;
    ImageView view;

    DatabaseHelper myDB;
    EditText number;
    EditText name;
    String dishname;
    String dishrecipe;
    Spinner cuis;
    String cuisine;

    EditText recipe;
    private static final int PICK_IMAGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        name = (EditText)findViewById(R.id.name);
        recipe = (EditText)findViewById(R.id.recipe);
        insert = (Button)findViewById(R.id.insert);

        get = (Button)findViewById(R.id.get);
        view = (ImageView)findViewById(R.id.imageView);

        number = (EditText)findViewById(R.id.number);
        myDB = new DatabaseHelper(this);
        cuis = (Spinner)findViewById(R.id.cuisine);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            Toast.makeText(this, "Not Granted", Toast.LENGTH_SHORT).show();
        }

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dishname = name.getText().toString();
                dishrecipe = recipe.getText().toString();
                cuisine = cuis.getSelectedItem().toString();

                Intent intent = new Intent(Intent.ACTION_PICK, Uri.parse(
                        "content://media/internal/images/media"
                ));
                startActivityForResult(intent,PICK_IMAGE);
            }
        });
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddProduct.this, AdminMenu.class);
                startActivity(intent);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK && requestCode==PICK_IMAGE){
            Uri uri = data.getData();
            String x = getPath(uri);
            Integer num = Integer.parseInt(number.getText().toString());
            if(myDB.insertProduct(dishname,x,num,dishrecipe, cuisine)){
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "NOT Success", Toast.LENGTH_SHORT).show();

            }
        }
    }

    private String getPath(Uri uri) {
        if(uri==null)
            return null;
        String projection = (MediaStore.Images.Media.DATA);
        Cursor cursor = managedQuery(uri, new String[]{projection},null,null,null);
        if(cursor!=null){
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }
        return uri.getPath();
    }
}
