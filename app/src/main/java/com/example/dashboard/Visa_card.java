package com.example.dashboard;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
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
        cn=(TextView)findViewById(R.id.textView14);
        ed=(TextView)findViewById(R.id.textViewne);
        n=(TextView)findViewById(R.id.textView12);
        id=(TextView)findViewById(R.id.textViewne1);
        iv=(ImageView)findViewById(R.id.imageView5);


        Cursor res =myDb.getAllData();
        while(res.moveToNext()) {
            id.setText(res.getString(0));
            n.setText(res.getString(1));

            String cc=res.getString(2);
            String cc2 =  cc.substring(cc.length() - 4);

            cn.setText("•••• •••• •••• "+cc2);
            ed.setText(res.getString(3));


        }
        DeleteData();
    }

    public void edit(View view) {

        startActivity(i5);
    }

    public void DeleteData(){
        iv.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(Visa_card.this);
                        builder.setTitle("Confirm to Delete Card !");
                        builder.setMessage("Do you want to Delete this Card details");
                        builder.setCancelable(false);
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Integer deletedRows = myDb.deleteData(id.getText().toString());
                                if(deletedRows >0){
                                    startActivity(idel);
                                    Toast.makeText(Visa_card.this, "Data Deleted", Toast.LENGTH_LONG).show();
                                }
                            }
                        });

                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Visa_card.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                            }
                        });

                        builder.show();

                    }
                }
        );
    }

}
