package com.example.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UserProfile extends AppCompatActivity {

    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        button2=(Button) findViewById(R.id.button6);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditUserProfile();
            }

            /*Bundle b=getIntent().getExtras();
            TextView name=(TextView) findViewById(R.id.textView6);
            TextView email=(TextView) findViewById(R.id.textView8);
            TextView phonr=(TextView) findViewById(R.id.textView9);



           // name.setText(b.getCharSequence("name"));
            //email.setText(b.getCharSequence("email"));
            //phonr.setText(b.getCharSequence("phonr"));*/
        });
    }
    public void openEditUserProfile(){
        Intent intent=new Intent(this,EditUserProfile.class);
        startActivity(intent);
    }

}
