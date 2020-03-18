package com.example.delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText door,address,city,contact;
    private Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        door = findViewById(R.id.door);
        address = findViewById(R.id.address);
        city = findViewById(R.id.city);
        contact = findViewById(R.id.contact);
        save = findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String data1 = door.getText().toString();
                String data2 = address.getText().toString();
                String data3 = city.getText().toString();
                String data4 = contact.getText().toString();

                Intent intent = new Intent(MainActivity.this,DeliveryData.class);
                intent.putExtra("door",0);

                startActivity(intent);
            }
        });
    }


}
