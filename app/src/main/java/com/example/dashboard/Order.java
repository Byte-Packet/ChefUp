package com.example.dashboard;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Order extends AppCompatActivity {


    DatabaseHelper_Order myDb;

    private Button button1;

    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4,textView5,textView6;

    Button button2;

    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


        myDb = new DatabaseHelper_Order(this);



        textView1=(TextView) findViewById(R.id.dishname);

        textView1.setText(getIntent().getStringExtra("Recipe_name"));


        button1=(Button) findViewById(R.id.button5);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUserProfile();
            }
        });

        textView4=(TextView) findViewById(R.id.dishname);
        textView5=(TextView) findViewById(R.id.quantity);
        textView6=(TextView) findViewById(R.id.price);
        button2=(Button) findViewById(R.id.confirmOrder);
        button3=(Button) findViewById(R.id.viewOrder);
         AddData();
        viewAll();

    }

    public void AddData(){
        button2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean inserted=myDb.insertData(textView4.getText().toString(),textView6.getText().toString());

                        if (inserted= true)
                        {
                            Toast.makeText(Order.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        }
                        else
                            Toast.makeText(Order.this,"Data not inserted",Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
    public void viewAll(){

        button3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res=myDb.getAllData();

                        if (res.getCount()==0) {

                            showMessage("ERROR","No Data Found");
                            return;
                        }
                        StringBuffer buffer=new StringBuffer();
                        while (res.moveToNext()){

                            buffer.append("ID :"+res.getString(0)+"\n");
                            buffer.append("dish name :"+res.getString(1)+"\n");
                            buffer.append("total :"+res.getString(2)+"\n\n");
                        }
                        showMessage("Data",buffer.toString());

                    }
                }
        );
    }
    public void showMessage(String title, String message){

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void openUserProfile(){
        Intent intent=new Intent(this,UserProfile.class);
        startActivity(intent);
    }


}
