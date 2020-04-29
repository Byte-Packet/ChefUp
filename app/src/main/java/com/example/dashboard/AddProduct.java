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
    RadioButton cuisine1;
    RadioButton cuisine2;
    RadioButton cuisine3;
    RadioButton cuisine4;
    RadioButton cuisine5;
    RadioButton cuisine6;
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
        cuisine1 = (RadioButton)findViewById(R.id.cuisine1) ;
        cuisine2 = (RadioButton)findViewById(R.id.cuisine2) ;
        cuisine3 = (RadioButton)findViewById(R.id.cuisine3) ;
        cuisine4 = (RadioButton)findViewById(R.id.cuisine4) ;
        cuisine5 = (RadioButton)findViewById(R.id.cuisine5) ;
        cuisine6 = (RadioButton)findViewById(R.id.cuisine6) ;
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
                if(cuisine1.isChecked()==true){
                    cuisine = "Sri Lankan";
                }
                else if(cuisine2.isChecked()==true){
                    cuisine = "Indian";
                }
                else if(cuisine3.isChecked()==true){
                    cuisine = "Italian";
                }
                else if(cuisine4.isChecked()==true) {
                    cuisine = "American";
                }
                else if(cuisine5.isChecked()==true){
                    cuisine = "Arabic";
                }
                else if(cuisine6.isChecked()==true){
                    cuisine = "Chinese";
                }

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
