package com.example.dashboard;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Visa_card extends AppCompatActivity {
    DatabaseHelper_pay myDb;
    TextView cn,ed,n;
    TextView id;
    ImageView iv;
    Intent idel;

    Intent i5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visa_card);

    }
}
