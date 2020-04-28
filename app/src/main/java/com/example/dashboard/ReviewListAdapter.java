package com.example.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

/**
 * Created by Belal on 9/14/2017.
 */

//we need to extend the ArrayAdapter class as we are building an adapter
public class ReviewListAdapter extends ArrayAdapter<Review> {

    //the list values in the List of type hero
    List<Review> reviewList;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public ReviewListAdapter(Context context, int resource, List<Review> reviewList) {
        super(context, resource, reviewList);
        this.context = context;
        this.resource = resource;
        this.reviewList = reviewList;
    }

    //this will return the ListView Item as a View
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View view = layoutInflater.inflate(resource, null, false);

        //getting the view elements of the list from the view
        TextView textViewName = view.findViewById(R.id.reviewer_name);
        TextView textViewTeam = view.findViewById(R.id.the_review);

        //getting the hero of the specified position
        Review review = reviewList.get(position);

        //adding values to the list item
        textViewName.setText(review.getName());
        textViewTeam.setText(review.getReview());

        //finally returning the view
        return view;
    }
}