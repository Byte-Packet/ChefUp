package com.example.dashboard;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper_order extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME="ChefUp_Order.db";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE_NAME="Order_Table";
    private static final String COL_ID="Order_id";
    private static final String COL_DISH_NAME="Dishn_ame";
    private static final String COL_QUANTITY="Quantity";
    private static final String COL_PRICE="Price";
    private static final String COL_TOTAL="Total";



    public DatabaseHelper_order(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String querry="CREATE TABLE "+ TABLE_NAME+ " (" +COL_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+ COL_DISH_NAME +" TEXT, "+ COL_QUANTITY +" INTEGER," + COL_PRICE +" INTEGER , "+ COL_TOTAL +" INTEGER);";
        db.execSQL(querry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
    }
    public void addOrder(String dishName, int Qty, int price,int total){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL_DISH_NAME,dishName);
        cv.put(COL_QUANTITY,Qty);
        cv.put(COL_PRICE,price);
        cv.put(COL_TOTAL,total);

        long result=db.insert(TABLE_NAME,null,cv);

        if (result==-1)
        {
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show();
        }
    }
    public Cursor readAllData(){

        String querry="SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=null;

        if (db!=null){
            cursor=db.rawQuery(querry,null);
        }
        return cursor;
    }
    public void updateOrder(String row_id,String dishName,String quantity,String price,String total){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL_DISH_NAME,dishName);
        cv.put(COL_QUANTITY,quantity);
        cv.put(COL_PRICE,price);
        cv.put(COL_TOTAL,total);


        long result=db.update(TABLE_NAME,cv,"Order_ID =?",new String[]{row_id});
        if (result==-1){
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context,"Successfully updated",Toast.LENGTH_SHORT).show();
        }

    }
    void deleteRow(String row_id){

        SQLiteDatabase db=this.getWritableDatabase();
        long result=db.delete(TABLE_NAME,"Order_id=?",new String[]{row_id});
        if (result==-1){

            Toast.makeText(context,"Failed deleted",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context,"Successfully deleted",Toast.LENGTH_SHORT).show();
        }
    }
    void deleteAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_NAME);
    }


    public int getTotal(){
        SQLiteDatabase db=this.getReadableDatabase();

        int total = 0;
        String[] column= new String[]{COL_ID,COL_DISH_NAME,COL_QUANTITY,COL_PRICE,COL_TOTAL};
        Cursor c=db.query(TABLE_NAME,column,null,null,null,null,null);




        if (c.getCount()>0){
            for (c.moveToFirst();!c.isAfterLast();c.moveToNext()){
                total=total+c.getInt(c.getColumnIndex(COL_TOTAL));;
            }
        }

        /*
        Cursor cursor=db.rawQuery("SELECT SUM("+COL_TOTAL+") FROM "+TABLE_NAME,null);
        if (cursor.moveToFirst()){
             total=cursor.getInt(cursor.getColumnIndex("Total"));
        }*/
        return total;

    }

}
