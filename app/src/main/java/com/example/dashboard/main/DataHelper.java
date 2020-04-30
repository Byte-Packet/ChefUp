package com.example.dashboard.main;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Chefup.db";
    public static final String TABLE_NAME = "delivery";

    public static final String COL1 = "ID";
    public static final String COL2 = "DOOR";
    public static final String COL3 = "ADDRESS";
    public static final String COL4 = "CITY";
    public static final String COL5 = "CONTACT";

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT,DOOR TEXT,ADDRESS TEXT,CITY TEXT,CONTACT TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    //Insert
    public boolean insertData(String door, String address, String city, String contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,door);
        contentValues.put(COL3,address);
        contentValues.put(COL4,city);
        contentValues.put(COL5,contact);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;

    }
}
