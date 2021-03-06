package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    ArrayList<Product> menulist = null;

    String namevalue, addressvalue, emailvalue;
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
        view_recipe = (Button)findViewById(R.id.viewbtn);
        namevalue = "drynriehiuyhjihdnec";
        addressvalue = "jidrgirchrth";
        emailvalue = "ejr";
        Intent intent= new Intent(Menu.this, ViewRec.class);
        intent.putExtra("Name",namevalue);
        intent.putExtra("Address",addressvalue);
        intent.putExtra("Email",emailvalue);

        menulist = new ArrayList<>();
        loadData();
    }
    private void loadData() {
        menulist = myDB.displayMenu();
        adapter = new ProductAdapterList(menulist, this);
        menu.setAdapter(adapter);
    }

}



