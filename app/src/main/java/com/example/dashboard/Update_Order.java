package com.example.dashboard;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Update_Order extends AppCompatActivity {

    EditText dish_name_input,quantity_input,price_input;
    Button update_button;
    Button delete_button;


    String id,dishName,qty,price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__order);

        dish_name_input=findViewById(R.id.dishName2);
        quantity_input=findViewById(R.id.quantity2);
        price_input=findViewById(R.id.price2);
        update_button=findViewById(R.id.updateOrderDetails);
        delete_button=findViewById(R.id.deleteButton);



        getAndSetIntentData();

        ActionBar actionBar=getSupportActionBar();
        if(actionBar != null ){
            actionBar.setTitle(dishName);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  DatabaseHelper_order myDb=new DatabaseHelper_order(Update_Order.this);
                //myDb.updateOrder(id, dishName, qty, price);

            }
        });


        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               confirmDialog();
            }
        });



    }

    public void getAndSetIntentData(){


        if (getIntent().hasExtra("id") && getIntent().hasExtra("dishName") && getIntent().hasExtra("qty") &&
                getIntent().hasExtra("price")){
            //Getting data from intent
            id=getIntent().getStringExtra("id");
            dishName=getIntent().getStringExtra("dishName");
            qty=getIntent().getStringExtra("qty");
            price=getIntent().getStringExtra("price");

            //Setting data

            dish_name_input.setText(dishName);
            quantity_input.setText(qty);
            price_input.setText(price);
        }
        else {
            Toast.makeText(this,"No data ",Toast.LENGTH_SHORT).show();
        }
    }
    void confirmDialog(){

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Delete "+ dishName+ " ?");
        builder.setMessage("Are you sure want to delete "+dishName);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DatabaseHelper_order myDB=new  DatabaseHelper_order(Update_Order.this);
                myDB.deleteRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();

    }


}
