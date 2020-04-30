package com.example.dashboard;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dashboard.main.Preparing;

import java.util.Timer;
import java.util.TimerTask;

public class OrderConfirmed extends AppCompatActivity {

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmed);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(OrderConfirmed.this, Preparing.class);
                startActivity(intent);
            }
        },5000);
    }
}
