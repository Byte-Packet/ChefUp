package com.example.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DeliveryData extends AppCompatActivity {

    TextView door,address,city,contact;
    Button select,edit,delete,add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_data);

        door = findViewById(R.id.door);
        address = findViewById(R.id.address);
        city = findViewById(R.id.city);
        contact = findViewById(R.id.contact);

        select = findViewById(R.id.select1);
        edit = findViewById(R.id.edit1);
        delete = findViewById(R.id.delete1);
        add = findViewById(R.id.add);

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeliveryData.this,OrderConfirmed.class);
                startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeliveryData.this, AddDelivery.class);
                startActivity(intent);
            }
        });

    }
}
