package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    EditText uname, password, cpassword;
    Button reg , back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        uname = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        cpassword = (EditText)findViewById(R.id.confirm);
        reg = (Button)findViewById(R.id.register);
        back = (Button)findViewById(R.id.already);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String namevalue=uname.getText().toString();
                String passvalue=password.getText().toString();
                String cpassvalue=cpassword.getText().toString();

                Intent intent= new Intent(Register.this, UserProfile.class);

                intent.putExtra("Name",namevalue);
                intent.putExtra("Password",passvalue);
                intent.putExtra("Password",cpassvalue);

                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
    }
}
