package com.example.dashboard;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dashboard.main.AddDelivery;
import com.example.dashboard.main.DeliveryData;
import com.example.dashboard.main.OrderConfirmed;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Order extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;
    Button button,button3;

    TextView sum_of_total;

    DatabaseHelper_order myDb;

    ArrayList<String> order_id,dish_name,quantity,price,total;

    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        button=findViewById(R.id.button);
        button3=findViewById(R.id.button3);
        sum_of_total=findViewById(R.id.totalValue);
        recyclerView=findViewById(R.id.recyclerview);
        add_button=findViewById(R.id.addOrder);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Order.this,AddOrder.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Order.this,DeliveryData.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Order.this,OrderConfirmed.class);
                startActivity(intent);
            }
        });
        myDb=new DatabaseHelper_order(Order.this);
        order_id=new ArrayList<>();
        dish_name=new ArrayList<>();
        quantity=new ArrayList<>();
        price=new ArrayList<>();
        total=new ArrayList<>();

        sum_of_total.setText(Integer.toString(myDb.getTotal()));
        storeDataInArrays();
        customAdapter=new CustomAdapter(Order.this,Order.this,order_id,dish_name,quantity,price,total);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Order.this));


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode== 1){
            recreate();
        }
    }

    void storeDataInArrays(){

        Cursor cursor=myDb.readAllData();
        if (cursor.getCount()==0){

            Toast.makeText(this,"No data",Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){

                order_id.add(cursor.getString(0));
                dish_name.add(cursor.getString(1));
                quantity.add(cursor.getString(2));
                price.add(cursor.getString(3));
                total.add(cursor.getString(4));
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.deleteAll){
            //Toast.makeText(this,"Delete",Toast.LENGTH_SHORT).show();
            confirmDialog();
        }
        return super.onOptionsItemSelected(item);
    }
    void confirmDialog(){

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Delete All order ");
        builder.setMessage("Are you sure want to delete ? ");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DatabaseHelper_order myDB=new  DatabaseHelper_order(Order.this);

                myDb.deleteAllData();
                //Refresh app
                Intent intent=new Intent(Order.this,Order.class);
                startActivity(intent);
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

    public void orderPay(View view) {
        Intent inew= new Intent(this,pay_main.class);
        startActivity(inew);

    }
}