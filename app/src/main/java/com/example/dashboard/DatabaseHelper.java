package com.example.dashboard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import static android.os.Build.ID;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ChefUp.db";
    public static final String REVIEWTAB = "ReviewTable";
    public static final String PRODUCTTAB = "Products";
    public static final String IMAGETAB = "Images";

    public static final String ProdCOL_1 = "ID";
    public static final String ProdCOL_2 = "Name";
    public static final String ProdCOL_3 = "Image";
    public static final String ProdCOL_4 = "Recipe";

    public static final String REVIEWCOL_1 = "ID";
    public static final String REVIEWCOL_2 = "Name";
    public static final String REVIEWCOL_3 = "Review";

    ByteArrayOutputStream byteArray;
    Context context;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 5);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + REVIEWTAB + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, REVIEW TEXT)");
        db.execSQL("create table " + IMAGETAB + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, RECIPE TEXT, CUISINE TEXT, Image BLOB)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + REVIEWTAB);
        db.execSQL("DROP TABLE IF EXISTS " + PRODUCTTAB);
        db.execSQL("DROP TABLE IF EXISTS " + IMAGETAB);
        onCreate(db);
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
    public boolean insertProduct(String name, String x, Integer img, String recipe, String cuisine){
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            FileInputStream fs = new FileInputStream(x);
            byte[] imgbyte = new byte[fs.available()];
            fs.read(imgbyte);
            ContentValues contentValues = new ContentValues();
            contentValues.put("ID",img);
            contentValues.put("NAME",name);
            contentValues.put("RECIPE",recipe);
            contentValues.put("Image",imgbyte);
            contentValues.put("CUISINE", cuisine);

            long result = db.insert(IMAGETAB, null,contentValues);
            fs.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public Cursor displayAllReviews(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from "+ REVIEWTAB;
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }

    public ArrayList<Product> displayMenu(){

        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Product> menulist = new ArrayList<>();
        String query = "select * from "+ IMAGETAB;
        Cursor cursor = db.rawQuery(query, null);
        Bitmap bt = null;
        while(cursor.moveToNext())
        {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String recipe = cursor.getString(2);
            String cuisine = cursor.getString(3);
            byte[] img = cursor.getBlob(4);
            bt = BitmapFactory.decodeByteArray(img,0,img.length);

            Product prod = new Product(id, bt, name, recipe, cuisine);
            menulist.add(prod);
        }
        return menulist;
    }
    public Product displayRecipe(Product rec){

        SQLiteDatabase db = this.getReadableDatabase();
        int id = rec.getId();
        Product prod = null;
        ArrayList<Product> menulist = new ArrayList<>();
        String query = "select * from "+ IMAGETAB + " where id = ?";
        Cursor cursor = db.rawQuery(query,  new String[]{String.valueOf(id)});
        Bitmap bt = null;
        while(cursor.moveToNext())
        {
            String name = cursor.getString(1);
            String recipe = cursor.getString(2);
            String cuisine = cursor.getString(3);
            byte[] img = cursor.getBlob(4);
            bt = BitmapFactory.decodeByteArray(img,0,img.length);

            prod = new Product(id, bt, name, recipe, cuisine);
        }
        return prod;
    }

    public boolean deleteRecipe(Product id){


        SQLiteDatabase db = this.getWritableDatabase();
        int  idd = id.getId();
        String ID = String.valueOf(idd);
        try{
            long result = db.delete(IMAGETAB, "id = ", new String[]{ID});
            return true;
        }catch (SQLException e){
                return false;
        }

    }
}
