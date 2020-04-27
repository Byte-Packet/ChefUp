package com.example.dashboard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ProductAdapterList extends BaseAdapter {
    List<Product> menu;
    Context context;

    public ProductAdapterList(List<Product> menu, Context context) {
        this.menu = menu;
        this.context = context;
    }

    @Override
    public int getCount() {
        return menu.size();
    }

    @Override
    public Object getItem(int position) {
        return menu;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //this will return the ListView Item as a View
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.adapter_menu,null);
        ImageView image = (ImageView)convertView.findViewById(R.id.imageView);
        TextView name = (TextView)convertView.findViewById(R.id.recipeName);
        Button view = (Button)convertView.findViewById(R.id.viewbtn) ;

        Product prod = menu.get(position);

            image.setImageBitmap(prod.getImage());
            name.setText(prod.getName());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, Recipe.class);
                    context.startActivity(intent);
                }
            });


        return convertView;
    }
}