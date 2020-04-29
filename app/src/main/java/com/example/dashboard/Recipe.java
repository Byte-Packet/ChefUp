package com.example.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import com.example.dashboard.main.SectionsPagerAdapter;

import java.util.ArrayList;

public class Recipe extends AppCompatActivity {
    ImageView image;
    Product prod;
    ArrayList prodList;
    DatabaseHelper myDB;
    TextView id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        image = (ImageView)findViewById(R.id.pic);
        myDB = new DatabaseHelper(this);
        id = (TextView)findViewById(R.id.idview);
        id.setText(getIntent().getStringExtra("Name"));
        //textView2.setText(getIntent().getStringExtra("Address"));
        prodList = new ArrayList<>();

        id.setText(getIntent().getStringExtra("Name"));
        /*textView2.setText(getIntent().getStringExtra("Address"));
        textView3.setText(getIntent().getStringExtra("Email"));*/


    }
}