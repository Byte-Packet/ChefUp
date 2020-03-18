package com.example.payment_option;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Visa_card extends AppCompatActivity {

    Intent i5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visa_card);

        i5=new Intent(this,editcard.class);
    }

    public void edit(View view) {

        startActivity(i5);
    }
}
