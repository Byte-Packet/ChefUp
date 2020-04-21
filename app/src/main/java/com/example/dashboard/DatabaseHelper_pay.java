package com.example.dashboard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper_pay extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="Customer_p.db";
    public static final String TABLE_NAME ="Customer_details_p";
    public static final String COL_1 ="ID";
    public static final String COL_2 ="NAME";
    public static final String COL_3 ="CARDNO";
    public static final String COL_4 ="EDATE";
    public static final String COL_5 ="CVV";


    public DatabaseHelper_pay(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,CARDNO INTEGER,EDATE DATE,CVV INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData(String name,String cardno,String edate,String cvv){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,cardno);
        contentValues.put(COL_4,edate);
        contentValues.put(COL_5,cvv);
        long result = db.insert(TABLE_NAME,null ,contentValues );
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }


    public boolean updateData(String id,String name,String cardno,String edate){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,cardno);
        contentValues.put(COL_4,edate);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;

    }

}
