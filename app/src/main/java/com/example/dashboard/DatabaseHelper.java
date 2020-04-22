package com.example.dashboard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ChefUp.db";
    public static final String REVIEWTAB = "ReviewTable";
    public static final String REVIEWCOL_1 = "ID";
    public static final String REVIEWCOL_2 = "Name";
    public static final String REVIEWCOL_3 = "Review";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + REVIEWTAB + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, REVIEW TEXT)");
    }
    public void recipe(SQLiteDatabase db){
        db.execSQL("create table " + REVIEWTAB + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, REVIEW TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + REVIEWTAB);
        recipe(db);
    }
    public boolean insertReview(String name,String review){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(REVIEWCOL_2,name);
        contentValues.put(REVIEWCOL_3,review);
        long result = db.insert(REVIEWTAB,null ,contentValues );
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor displayAllReviews(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ REVIEWTAB, null);
        return res;
    }
}
