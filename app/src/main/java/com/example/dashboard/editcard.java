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
    EditText edname, ednumber, eddate,ecvv;
    TextView id;
    Intent in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editcard);

        in=new Intent(this,pay_main.class);

        edname = (EditText) findViewById(R.id.editText);
        ednumber = (EditText) findViewById(R.id.editText2);
        eddate = (EditText) findViewById(R.id.editText7);
        ecvv=(EditText)findViewById(R.id.editText9);
        id = (TextView) findViewById(R.id.textViewid);

        myDb = new DatabaseHelper_pay(this);
        Cursor res = myDb.getAllData();

        while (res.moveToNext()) {
            edname.setText(res.getString(1));

            String cc=res.getString(2);
            String cc2 =  cc.substring(cc.length() - 4);

            ednumber.setText("•••• •••• •••• "+cc2);
            eddate.setText(res.getString(3));
            ecvv.setText(res.getString(4));
            id.setText(res.getString(0));


        }
        btnup = (Button) findViewById(R.id.button2);


        updateData();
    }

    public void updateData() {
        btnup.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(id.getText().toString(),edname.getText().toString(),
                                eddate.getText().toString(),ecvv.getText().toString());
                        if (isUpdate == true) {
                            startActivity(in);
                            Toast.makeText(editcard.this, "Data updated", Toast.LENGTH_LONG).show();
                        } else
                            Toast.makeText(editcard.this, "Data not updated", Toast.LENGTH_LONG).show();
                    }
                }
        );

    }
}