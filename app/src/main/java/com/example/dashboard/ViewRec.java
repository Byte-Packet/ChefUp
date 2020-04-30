package com.example.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewRec extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewrec);

        textView1=(TextView) findViewById(R.id.text1_activity2);
        textView2=(TextView) findViewById(R.id.text2_activity2);
        //textView3=(TextView) findViewById(R.id.textView9);

        textView1.setText(getIntent().getStringExtra("Name"));
        textView2.setText(getIntent().getStringExtra("Address"));
    }

}
