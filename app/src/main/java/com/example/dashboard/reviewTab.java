package com.example.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class reviewTab extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    EditText reviewer;
    EditText review;
    Button submit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_review_tab, container, false);

        View view = inflater.inflate(R.layout.fragment_review_tab, container, false);
        reviewer = view.findViewById(R.id.review_Name);
        review = view.findViewById(R.id.review);
        submit = (Button) getView().findViewById(R.id.submit);

        /*submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //boolean isInsert = myDB.insertReview(reviewer.getText().toString(),review.getText().toString());
                //if(isInsert =true){
                    Toast.makeText(getContext(),"Inserted", Toast.LENGTH_LONG).show();
                //}else{
                  //  Toast.makeText(getContext(),"Error", Toast.LENGTH_LONG).show();
                //}
            }
        });*/
        return view;
    }

}
