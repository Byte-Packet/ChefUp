package com.example.dashboard;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper_reviews extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Review.db";
    public static final String TABLE_NAME = "ReviewTable";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Name";
    public static final String COL_3 = "Review";
    public static final String COL_4 = "Name";

    public DatabaseHelper_reviews(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID PRIMARY KEY AUTOINCREMENT, NAME TEXT, REVIEW TEXT, STARS INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String name,String review){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,review);
        long result = db.insert(TABLE_NAME,null ,contentValues );
        if(result == -1)
            return false;
        else
            return true;
    }
}
