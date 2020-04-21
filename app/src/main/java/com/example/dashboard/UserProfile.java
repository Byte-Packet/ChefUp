package com.example.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserProfile extends AppCompatActivity {

    private Button button2;

    TextView textView1;
    TextView textView2;
    TextView textView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        textView1=(TextView) findViewById(R.id.textView6);
        textView2=(TextView) findViewById(R.id.textView8);
        textView3=(TextView) findViewById(R.id.textView9);

        textView1.setText(getIntent().getStringExtra("Name"));
        textView2.setText(getIntent().getStringExtra("Address"));
        textView3.setText(getIntent().getStringExtra("Email"));

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
