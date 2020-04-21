package com.example.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditUserProfile extends AppCompatActivity {

    Button button;

    EditText editText1;
    EditText editText2;
    EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_profile);

        editText1=(EditText) findViewById(R.id.name);
        editText2=(EditText) findViewById(R.id.email);
        editText3=(EditText) findViewById(R.id.phone);
        button=(Button) findViewById(R.id.button7);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String namevalue=editText1.getText().toString();
                String addressvalue=editText2.getText().toString();
                String emailvalue=editText3.getText().toString();

                Intent intent= new Intent(EditUserProfile.this, UserProfile.class);
                intent.putExtra("Name",namevalue);
                intent.putExtra("Address",addressvalue);
                intent.putExtra("Email",emailvalue);

                startActivity(intent);
            }
        });
    }

}
