package com.example.dashboard;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class editcard extends AppCompatActivity {
    DatabaseHelper_pay myDb;
    Button btnup;
    EditText edname, ednumber, eddate;
    TextView id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editcard);

        edname = (EditText) findViewById(R.id.editText);
        ednumber = (EditText) findViewById(R.id.editText2);
        eddate = (EditText) findViewById(R.id.editText7);
        id = (TextView) findViewById(R.id.textViewid);

        myDb = new DatabaseHelper_pay(this);
        Cursor res = myDb.getAllData();

        while (res.moveToNext()) {
            edname.setText(res.getString(1));
            ednumber.setText(res.getString(2));
            eddate.setText(res.getString(3));
            id.setText(res.getString(0));


        }
        btnup = (Button) findViewById(R.id.button2);



    }


}