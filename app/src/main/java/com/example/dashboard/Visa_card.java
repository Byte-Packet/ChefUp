package com.example.dashboard;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Visa_card extends AppCompatActivity {
    DatabaseHelper_pay myDb;
    TextView cn,ed,n;
    TextView id;
    ImageView iv;
    Intent idel;

    Intent i5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visa_card);

        idel=new Intent(this,pay_main.class);
        i5=new Intent(this,editcard.class);
        myDb = new DatabaseHelper_pay(this);
        cn=(TextView)findViewById(R.id.textView12);
        ed=(TextView)findViewById(R.id.textView14);
        n=(TextView)findViewById(R.id.textViewne);
        id=(TextView)findViewById(R.id.textViewne1);
        iv=(ImageView)findViewById(R.id.imageView5);

        Cursor res =myDb.getAllData();
        while(res.moveToNext()) {
            id.setText(res.getString(0));
            n.setText(res.getString(1));
            cn.setText(res.getString(2));
            ed.setText(res.getString(3));


        }

    }

    public void edit(View view) {

        startActivity(i5);
    }

    public void DeleteData(){
        iv.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(id.getText().toString());
                        if(deletedRows >0){
                            startActivity(idel);
                            Toast.makeText(Visa_card.this, "Data Deleted", Toast.LENGTH_LONG).show();
                        }
                        else
                            Toast.makeText(Visa_card.this,"Data not Deleted",Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
}
