package com.example.dashboard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper_order extends SQLiteOpenHelper {


    public static final String DATABASE_NAME="Order.db";
    public static final String TABLE_NAME="Order_table";
    public static final String COL_1="Order_ID";
    public static final String COL_2="Dish_name";
    public static final String COL_3="total_cost";



    public DatabaseHelper_order(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db=this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME +" (Order_ID INTEGER PRIMARY KEY AUTOINCREMENT,  Dish_name TEXT, total_cost INTEGER )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
