package com.example.order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditUserProfile extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_profile);

        button=(Button) findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                openUserProfile();
            }

        });



    }

    public void openUserProfile(){
        Intent intent=new Intent(this,UserProfile.class);
        startActivity(intent);
    }

}
