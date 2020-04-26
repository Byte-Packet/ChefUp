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


        textView1=(TextView) findViewById(R.id.textView2);

        //textView1.setText(getIntent().getStringExtra("Recipe_name"));


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



    }


    public void openUserProfile(){
        Intent intent=new Intent(this,EditUserProfile.class);
        startActivity(intent);
    }


}
