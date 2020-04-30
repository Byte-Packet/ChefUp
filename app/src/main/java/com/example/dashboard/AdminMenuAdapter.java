package com.example.dashboard;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.util.ArrayList;
import java.util.List;

public class AdminMenuAdapter extends BaseAdapter {
    List<Product> menu;
    Context context;
    OnItemClickListener mListener;
    Product prod;
    DatabaseHelper myDb;
    int id;
    Bundle bundle;
    ArrayList<Product> menulist;
    Button update, del;

    public AdminMenuAdapter(List<Product> menu, Context context) {
        this.menu = menu;
        this.context = context;
    }

    public void setOnItemClickListener(ProductAdapterList.OnItemClickListener recipe) {
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
        convertView = inflater.inflate(R.layout.adapteradmin_menu,null);
        ImageView image = (ImageView)convertView.findViewById(R.id.imageView);
        TextView name = (TextView)convertView.findViewById(R.id.recipeName);
        Button view = (Button)convertView.findViewById(R.id.viewbtn) ;
        update = (Button)convertView.findViewById(R.id.updatbtn);
        del = (Button)convertView.findViewById(R.id.delbtn);
        bundle = new Bundle();

        prod = menu.get(position);

        image.setImageBitmap(prod.getImage());
        name.setText(prod.getId() + "  " + prod.getName());
        myDb = new DatabaseHelper(context);
        menu = myDb.displayMenu();
        id = prod.getId();


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Recipe.class);
                context.startActivity(intent);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DeleteProduct.class);
                context.startActivity(intent);
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check =  myDb.deleteRecipe(prod);
                if(check == false){
                    Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                }

                //Intent intent = new Intent(context, DeleteProduct.class);
                //context.startActivity(intent);
            }
        });

        return convertView;
    }
}