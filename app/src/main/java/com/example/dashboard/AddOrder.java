package com.example.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddOrder extends AppCompatActivity {

    EditText dishName_input,quantity_input,price_input;
    Button add_button;
    Button add_profile;
    Button view_cart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);

        dishName_input=findViewById(R.id.dishName);
        quantity_input=findViewById(R.id.quantity);
        price_input=findViewById(R.id.price);

        add_button=findViewById(R.id.addOrderDetails);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper_order myDb=new DatabaseHelper_order(AddOrder.this);
                myDb.addOrder(dishName_input.getText().toString().trim(),Integer.valueOf(quantity_input.getText().toString().trim()),Integer.valueOf(price_input.getText().toString().trim()));

            }
        });


        add_profile=findViewById(R.id.addProfile);
        add_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUserProfile();
            }
        });

        view_cart=findViewById(R.id.viewCart);
        view_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYourCart();
            }
        });

    }
    public void openUserProfile(){
        Intent intent=new Intent(AddOrder.this,EditUserProfile.class);
        startActivity(intent);
    }
    public void openYourCart(){
        Intent intent=new Intent(AddOrder.this,Order.class);
        startActivity(intent);
    }

}
