package com.example.dashboard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper_Order extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="ChefUp.db";
    public static final String TABLE_NAME ="Order_details";
    public static final String COL_1 ="ORDER_ID";
    public static final String COL_2 ="DISH_NAME";
    public static final String COL_3 ="TOTAL";


    public DatabaseHelper_Order(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+ TABLE_NAME +" (ORDER_ID INTEGER PRIMARY KEY AUTOINCREMENT,DISH_NAME TEXT,TOTAL INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public  boolean insertData(String dishname,String total){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,dishname);
        contentValues.put(COL_3,total);



        long result=db.insert(TABLE_NAME,null,contentValues);
        if (result==-1)
            return false;
            else
                return true;


    }
    public Cursor getAllData(){

        SQLiteDatabase db=this.getWritableDatabase();

        Cursor res= db.rawQuery("select * from "+ TABLE_NAME,null);
        return res;
    }
}
