package com.example.dashboard;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapterList extends BaseAdapter {
    List<Product> menu;
    Context context;
    OnItemClickListener mListener;
    Product prod;
    DatabaseHelper myDb;
    String namevalue, addressvalue, emailvalue;
    Bundle bundle;

    public ProductAdapterList(List<Product> menu, Context context) {
        this.menu = menu;
        this.context = context;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
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

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.adapter_menu,null);
        ImageView image = (ImageView)convertView.findViewById(R.id.imageView);
        TextView name = (TextView)convertView.findViewById(R.id.recipeName);
        Button view = (Button)convertView.findViewById(R.id.viewbtn) ;
        Button del = (Button)convertView.findViewById(R.id.delbtn) ;
        bundle = new Bundle();
        prod = menu.get(position);

            image.setImageBitmap(prod.getImage());
            name.setText(prod.getName());
            myDb = new DatabaseHelper(context);

            view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namevalue = "drynriehiuyhjihdnec";
                addressvalue = "jidrgirchrth";
                emailvalue = "ejr";
                Intent intent= new Intent(context, Recipe.class);
                intent.putExtra("Name",namevalue);
                intent.putExtra("Address",addressvalue);
                intent.putExtra("Email",emailvalue);

                context.startActivity(intent);
            }
        });

        return convertView;
    }
}