package com.example.dashboard;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.craftman.cardform.CardForm;

public class addCard extends AppCompatActivity {
    DatabaseHelper_pay myDb;
    EditText editName,editCardNo,editEdate,editCvv;
    Button btnAdd;

    AlertDialog.Builder alertBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);
        myDb = new DatabaseHelper_pay(this);

      
    }
}
