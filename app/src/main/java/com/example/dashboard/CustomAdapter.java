package com.example.dashboard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

   private Context context;
   private ArrayList order_id,dish_name,quantity,price;

   Activity activity;

    CustomAdapter(Activity activity,Context context,ArrayList order_id,ArrayList dish_name,ArrayList quantity,ArrayList price){

        this.activity=activity;
        this.context=context;
        this.order_id=order_id;
        this.dish_name=dish_name;
        this.quantity=quantity;
        this.price=price;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {



        holder.order_id_txt.setText(String.valueOf(order_id.get(position)));
        holder.dish_name_txt.setText(String.valueOf(dish_name.get(position)));
        holder.quantity_txt.setText(String.valueOf(quantity.get(position)));
        holder.price_txt.setText(String.valueOf(price.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context,Update_Order.class);
                intent.putExtra("id",String.valueOf(order_id.get(position)));
                intent.putExtra("dishName",String.valueOf(dish_name.get(position)));
                intent.putExtra("qty",String.valueOf(quantity.get(position)));
                intent.putExtra("price",String.valueOf(price.get(position)));
                activity.startActivityForResult(intent,1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return order_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView order_id_txt,dish_name_txt,quantity_txt,price_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            order_id_txt=itemView.findViewById(R.id.order_Id_txt);
            dish_name_txt=itemView.findViewById(R.id.dish_name_txt);
            quantity_txt=itemView.findViewById(R.id.quantity_txt);
            price_txt=itemView.findViewById(R.id.price_txt);
            mainLayout=itemView.findViewById(R.id.mainLayout);
        }
    }
}
