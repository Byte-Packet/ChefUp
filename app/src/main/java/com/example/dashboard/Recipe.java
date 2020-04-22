package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;

import com.example.dashboard.main.SectionsPagerAdapter;

public class Recipe extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText name;
    EditText review;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDB = new DatabaseHelper(this);
        setContentView(R.layout.activity_recipe);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        name = (EditText)findViewById(R.id.review_Name);
        review = (EditText)findViewById(R.id.review);
        submit = (Button)findViewById(R.id.submit);

    }
}
