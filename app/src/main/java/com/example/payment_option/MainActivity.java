package com.example.payment_option;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent intent,intent2,intent3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent=new Intent(this,cash.class);
        intent2=new Intent(this,add_payment_method.class);
        intent3=new Intent(this,Visa_card.class);

    }

    public void cash_payemnt(View view) {
       startActivity(intent);
    }

    public void add(View view) {
        startActivity(intent2);
    }

    public void visacard(View view) {

        startActivity(intent3);
    }
}
