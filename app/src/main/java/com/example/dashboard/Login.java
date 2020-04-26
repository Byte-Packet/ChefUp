package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        submit = (Button)findViewById(R.id.login);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(), password.getText().toString());
            }
        });
    }

    public void validate(String name, String password){
        if(name.equals("User")&& password.equals("1234")) {
            Intent intent = new Intent(Login.this, Menu.class);
            startActivity(intent);
        }
        else if(name.equals("Admin")&& password.equals("1234")){
            Intent intent = new Intent(Login.this,Admin.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(Login.this, "Incorrect Login", Toast.LENGTH_SHORT).show();
        }


    }

}

