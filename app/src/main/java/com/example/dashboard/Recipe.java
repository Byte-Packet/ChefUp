package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Recipe extends AppCompatActivity {

<<<<<<< Updated upstream
    private Button add_order;
    TextView textView;
=======
    //DatabaseHelper_reviews recDB;
>>>>>>> Stashed changes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
<<<<<<< Updated upstream

        textView=(TextView) findViewById(R.id.textView2);
        add_order = (Button)findViewById(R.id.addorder);

        add_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String recipenamevalue=textView.getText().toString();
                Intent intent = new Intent(Recipe.this,Order.class);
                intent.putExtra("Recipe_name",recipenamevalue);

                startActivity(intent);
            }
        });

=======
        //recDB = new DatabaseHelper_reviews(this);
>>>>>>> Stashed changes
    }
}
