package com.example.dashboard.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dashboard.R;

public class AddDelivery extends AppCompatActivity {

    DataHelper myDb;

    public static final String EXTRA_MESSAGE = "com.example.delivery";
    EditText etdoor,etaddress,etcity,etcontact;
    Button save;

    String door;
    String address;
    String city;
    String contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_details);

        myDb = new DataHelper(this);

        etdoor = (EditText) findViewById(R.id.etdoor);
        etaddress = (EditText) findViewById(R.id.etaddress);
        etcity = (EditText) findViewById(R.id.etcity);
        etcontact = (EditText) findViewById(R.id.etcontact);
        save = (Button) findViewById(R.id.save);
        register();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register(); //Call when Button is Clicked
            }
        });

    }
    //Register
    public void register() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData(etdoor.getText().toString(),etaddress.getText().toString(),etcity.getText().toString(),etcontact.getText().toString());
                if (isInserted = true){
                    Toast.makeText(AddDelivery.this,"Data Added",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(AddDelivery.this,DeliveryData.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(AddDelivery.this,"Data Not Added",Toast.LENGTH_LONG).show();
            }
        });
    }

}
