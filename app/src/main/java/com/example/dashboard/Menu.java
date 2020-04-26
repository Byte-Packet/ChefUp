package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;

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
import java.util.List;

public class Menu extends AppCompatActivity {

    private Button show;
    ArrayList<Product> menulist = null;

    Button view;
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
    }
}



