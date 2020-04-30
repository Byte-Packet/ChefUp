package com.example.dashboard.main;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dashboard.Order;
import com.example.dashboard.R;

public class DeliveryData extends AppCompatActivity {

    DataHelper myDb;

    TextView door1,address1,city1,contact1;
    Button select,edit,delete,add,view,order;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_data);

        //Database
        myDb = new DataHelper(this);


        //Casting
        door1 = findViewById(R.id.door1);
        address1 = findViewById(R.id.address1);
        city1 = findViewById(R.id.city1);
        contact1 = findViewById(R.id.contact1);


        select = findViewById(R.id.select1);
        edit = findViewById(R.id.edit1);
        delete = findViewById(R.id.delete1);
        add = findViewById(R.id.add);
        view = findViewById(R.id.view);
        order = findViewById(R.id.order);
        viewAll();

        //Select Button
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeliveryData.this, AddDelivery.class);
                startActivity(intent);
            }
        });

        //add Button
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeliveryData.this, AddDelivery.class);
                startActivity(intent);
            }
        });

        //Order Button
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeliveryData.this, Order.class);
                startActivity(intent);
            }
        });

    }
    //View
    public void viewAll(){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();
                if (res.getCount() == 0){
                    showMessage("Error","No Data");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("ID :"+ res.getString(0)+"\n");
                    buffer.append("Door No :"+ res.getString(1)+"\n");
                    buffer.append("Address :"+ res.getString(2)+"\n");
                    buffer.append("City :"+ res.getString(3)+"\n");
                    buffer.append("Contact :"+ res.getString(4)+"\n"+"\n");

                }
                showMessage("Addresses ",buffer.toString());

            }
        });
    }

    //ShowMessage
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
