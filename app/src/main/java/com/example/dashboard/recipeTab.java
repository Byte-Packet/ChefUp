package com.example.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;


public class recipeTab extends Fragment {

   private Button button1;
   TextView recipe;
   TextView recipeName;
   Product prod;

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

        /*Intent intent = intent.getIntent();
        Product prod = intent.getParcelableExtra("id");*/

        button1 = view.findViewById(R.id.addToCart);
        recipe = view.findViewById(R.id.tot_recipe);
        recipeName = view.findViewById(R.id.recipeName);




        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(prod!=null) {
                    Intent intent = new Intent(getActivity(), Order.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(getActivity(), "No Object Selected", Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }





}
