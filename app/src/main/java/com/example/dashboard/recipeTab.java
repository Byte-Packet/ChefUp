package com.example.dashboard;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class recipeTab extends Fragment {

   private Button button1;
   TextView recipe;
   TextView recipeName;
   Product prod;
   DatabaseHelper myDB;
   Bitmap img;
   ArrayList<Product> list;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_recipe_tab, container, false);
        View view = inflater.inflate(R.layout.fragment_recipe_tab, container, false);

        //Intent intent = intent.getIntent();
        //Product prod = intent.getParcelableExtra("id");
        myDB = new DatabaseHelper(getActivity());
        button1 = view.findViewById(R.id.addToCart);
        recipe = view.findViewById(R.id.tot_recipe);
        recipeName = view.findViewById(R.id.recipeName);
       // img = view.findViewById(R.id.)


        list = myDB.displayMenu();
        prod = list.get(0);

        recipeName.setText(prod.getName().toString());
        recipe.setText(prod.getRecipe().toString());


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), AddOrder.class);
                  //  intent.putExtra("Obj", prod);
                    startActivity(intent);
            }
        });

        return view;
    }





}
