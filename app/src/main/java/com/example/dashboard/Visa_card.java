package com.example.dashboard;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Visa_card extends AppCompatActivity {
    DatabaseHelper_pay myDb;
    TextView cn,ed;

    Intent i5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visa_card);

        i5=new Intent(this,editcard.class);
        myDb = new DatabaseHelper_pay(this);
        cn=(TextView)findViewById(R.id.textView12);
        ed=(TextView)findViewById(R.id.textView14);

        Cursor res =myDb.getAllData();
        while(res.moveToNext()) {

            cn.setText(res.getString(2));
            ed.setText(res.getString(3));


        }

    }

    public void edit(View view) {

        startActivity(i5);
    }
}
