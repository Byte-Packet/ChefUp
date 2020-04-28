package com.example.dashboard;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class reviewTab extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    EditText reviewer;
    EditText review;
    Button submit;
    DatabaseHelper myDB;

    ArrayList<Review> reviewList;
    ListView reviews;
    ReviewListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_review_tab, container, false);

        View view = inflater.inflate(R.layout.fragment_review_tab, container, false);
        reviewer = view.findViewById(R.id.review_Name);
        review = view.findViewById(R.id.review);
        submit = view.findViewById(R.id.submittt);
        reviews = view.findViewById(R.id.reviews);
        reviewList = new ArrayList<Review>();
        myDB = new DatabaseHelper(getContext());

        viewData();
        /*//Create the Person objects
        Review john = new Review("John","sidnrghoimhcuthmthu");
        Review john1 = new Review("John","12-20-1998");
        Review john2 = new Review("John","12-20-1998");
        Review john3 = new Review("John","12-20-1998");
        Review john4 = new Review("John","12-20-1998");
        Review john5 = new Review("John","12-20-1998");
        Review john6 = new Review("John","12-20-1998");
        Review john7 = new Review("John","12-20-1998");
        Review john8 = new Review("John","12-20-1998");
        Review john9 = new Review("John","12-20-1998");



        //Add the Person objects to an ArrayList

        peopleList.add(john);
        peopleList.add(john1);
        peopleList.add(john2);
        peopleList.add(john3);
        peopleList.add(john4);
        peopleList.add(john5);
        peopleList.add(john6);
        peopleList.add(john7);
        peopleList.add(john8);
        peopleList.add(john9);


        ReviewListAdapter adapter = new ReviewListAdapter(getContext(), R.layout.adapter_view_layout, peopleList);
        reviews.setAdapter(adapter);*/

        reviews.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "You're in the setOnItemCLickListener", Toast.LENGTH_SHORT).show();
                String text = reviews.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), ""+text,Toast.LENGTH_SHORT).show();
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (reviewer.length() == 0) {
                    reviewer.setError("Enter Name");
                } else if (review.length() == 0) {
                    review.setError("Enter Review");
                } else {
                    boolean isInsert = myDB.insertReview(reviewer.getText().toString(), review.getText().toString());
                    if (isInsert = true) {
                        Toast.makeText(getContext(), "Inserted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        return view;
    }
    private void viewData(){
        Cursor cursor = myDB.displayAllReviews();

        if(cursor.getCount()==0){
            Toast.makeText(getContext(),"No data to show", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext())
            {
                String reviewww = cursor.getString(0);
                String name = cursor.getString(1);

                Review rev = new Review(name, reviewww);
                reviewList.add(rev);

            }
            adapter = new ReviewListAdapter(getContext(), R.layout.adapter_view_layout, reviewList);
            reviews.setAdapter(adapter);
        }
    }

}
