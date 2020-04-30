package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin extends AppCompatActivity {

    Button adddish;
    Button viewdish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

    adddish = (Button)findViewById(R.id.addDish);
    viewdish = (Button)findViewById(R.id.viewDish);

    adddish.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Admin.this, AddProduct.class);
            startActivity(intent);
        }
    });
    viewdish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin.this, AdminMenu.class);
                startActivity(intent);
            }
    });
    }
}
