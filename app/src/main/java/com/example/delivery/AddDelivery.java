package com.example.delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddDelivery extends AppCompatActivity {

    private EditText door,address,city,contact;
    private Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addDelivery);

        door = findViewById(R.id.door);
        address = findViewById(R.id.address);
        city = findViewById(R.id.city);
        contact = findViewById(R.id.contact);
        save = findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddDelivery.this,DeliveryData.class);
                startActivity(intent);
            }
        });
    }

}
