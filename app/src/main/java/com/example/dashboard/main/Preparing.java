package com.example.dashboard.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dashboard.R;

import java.util.Timer;
import java.util.TimerTask;

public class Preparing extends AppCompatActivity {

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preparing);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Preparing.this,Delivered.class);
                startActivity(intent);
            }
        },5000);
    }
}
