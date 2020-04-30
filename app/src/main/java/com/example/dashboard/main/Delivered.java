package com.example.dashboard.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dashboard.Menu;
import com.example.dashboard.R;

public class Delivered extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivered);

        //Button OnCLick
        button = findViewById(R.id.thank);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Delivered.this, Menu.class);
                startActivity(intent);
            }
        });

    }
}
