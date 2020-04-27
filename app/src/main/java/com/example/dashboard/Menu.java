package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    private Button show;
    ArrayList<Product> menulist = null;

    Button view_recipe;
    ListView menu;
    DatabaseHelper myDB;
    ProductAdapterList adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        myDB = new DatabaseHelper(this);
        menu = (ListView) findViewById(R.id.menu);

        menulist = new ArrayList<>();
        loadData();

    }
    private void loadData() {
        menulist = myDB.displayMenu();
        adapter = new ProductAdapterList(menulist, this);
        menu.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        view_recipe = (Button)findViewById(R.id.viewRecipe);


        view_recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Recipe.class);
                startActivity(intent);
            }
        });
    }
}



