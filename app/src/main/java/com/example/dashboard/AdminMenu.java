package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdminMenu extends AppCompatActivity {

    static ArrayList<Product> menulist = null;

    Button view_recipe;
    ListView menu;
    DatabaseHelper myDB;
    AdminMenuAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);
        myDB = new DatabaseHelper(this);
        menu = (ListView) findViewById(R.id.menu);
        view_recipe = (Button)findViewById(R.id.viewbtn);
        menulist = new ArrayList<>();
        menulist = myDB.displayMenu();
        loadData();
    }
    private void loadData() {
        adapter = new AdminMenuAdapter(menulist, this);
        menu.setAdapter(adapter);
    }
    public static void delete() {
        menulist.remove(0);
    }
}



