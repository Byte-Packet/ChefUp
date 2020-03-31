package com.example.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class add_payment_method extends AppCompatActivity {

    Intent i4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_payment_method);

        i4=new Intent(this,addCard.class);
    }

    public void addc(View view) {
       startActivity(i4);

    }
}
