package com.example.dashboard;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.craftman.cardform.CardForm;

public class addCard extends AppCompatActivity {

    AlertDialog.Builder alertBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        final CardForm cardForm = (CardForm) findViewById(R.id.cardform);

        TextView txtdes=(TextView)findViewById(R.id.payment_amount);
        final TextView num=(TextView)findViewById(R.id.card_number);
        TextView txtdes2=(TextView)findViewById(R.id.payment_amount_holder);
        Button btnAdd=(Button)findViewById(R.id.btn_pay);

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
}
