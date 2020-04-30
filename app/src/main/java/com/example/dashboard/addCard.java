package com.example.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.craftman.cardform.CardForm;

public class addCard extends AppCompatActivity {
    DatabaseHelper_pay myDb;
    EditText editName,editCardNo,editEdate,editCvv;
    Button btnAdd;
    Intent iadd;

    AlertDialog.Builder alertBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        iadd=new Intent(this,pay_main.class);

        myDb = new DatabaseHelper_pay(this);

        final CardForm cardForm = (CardForm) findViewById(R.id.cardform);

        editName=(EditText)findViewById(R.id.card_name);
        editCardNo=(EditText)findViewById(R.id.card_number);
        editEdate=(EditText)findViewById(R.id.expiry_date);
        editCvv=(EditText)findViewById(R.id.cvc);
        btnAdd=(Button)findViewById(R.id.btn_pay);
        AddData();

        TextView txtdes=(TextView)findViewById(R.id.payment_amount);
        //  final TextView num=(TextView)findViewById(R.id.card_number);
        TextView txtdes2=(TextView)findViewById(R.id.payment_amount_holder);


        txtdes.setText(null);
        txtdes2.setText(null);

        btnAdd.setText(String.format("Add Card"));

   /*     btnAdd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                 if (cardForm != null) {


                    alertBuilder =new AlertDialog.Builder(addCard.this);
                    alertBuilder.setTitle("Confirm before Add");
                    alertBuilder.setMessage("card number"+ num);

                }
            }
        });    */
    }
    public void AddData(){

        btnAdd.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editName.getText().toString(),
                                editCardNo.getText().toString(),editEdate.getText().toString(),
                                editCvv.getText().toString());
                        if(isInserted =true) {
                            startActivity(iadd);
                            Toast.makeText(addCard.this, "Data inserted", Toast.LENGTH_LONG).show();
                        }
                        else
                            Toast.makeText(addCard.this,"Data not inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
