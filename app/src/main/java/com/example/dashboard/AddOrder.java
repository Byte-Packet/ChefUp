package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddOrder extends AppCompatActivity {

    EditText dishName_input,quantity_input,price_input;
    //String price;
    //String quantity;

    //Double price_num,quantity_num,total_num;
    Button add_button;
    Button add_user_profile;
    Button your_cart;
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);

        dishName_input = findViewById(R.id.dishName);
        quantity_input = findViewById(R.id.quantity);
        price_input = findViewById(R.id.price);

        total=findViewById(R.id.total);

        add_button = findViewById(R.id.addOrderDetails);
        add_user_profile=findViewById(R.id.addProfile);
        your_cart=findViewById(R.id.yourCart);





        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                int a,b,c;
                a=Integer.parseInt(quantity_input.getText().toString());
                b=Integer.parseInt(price_input.getText().toString());

                c=a*b;
                total.setText(Integer.toString(c));

                DatabaseHelper_order myDb = new DatabaseHelper_order(AddOrder.this);

                myDb.addOrder(dishName_input.getText().toString().trim(), Integer.parseInt(quantity_input.getText().toString().trim()), Integer.parseInt(price_input.getText().toString().trim()),Integer.parseInt(total.getText().toString()));


            }
        });

        add_user_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProfile();
            }
        });
        your_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYourCart();
            }
        });





    }

    void openYourCart(){

        Intent intent=new Intent(AddOrder.this,Order.class);
        startActivity(intent);
    }
    void addProfile(){
        Intent intent=new Intent(AddOrder.this,UserProfile.class);
        startActivity(intent);
    }

}
