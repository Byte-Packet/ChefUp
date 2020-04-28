package com.example.dashboard;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {

    String cuisine;
    int id;
    String name;
    String recipe;
    Bitmap image;

    public Product(int id, Bitmap image, String name, String recipe, String cuisine) {
        this.image = image;
        this.name = name;
        this.recipe = recipe;
        this.cuisine = cuisine;
        this.id = id;
    }

    protected Product(Parcel in) {
        cuisine = in.readString();
        id = in.readInt();
        name = in.readString();
        recipe = in.readString();
        image = in.readParcelable(Bitmap.class.getClassLoader());
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bitmap getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getRecipe() {
        return recipe;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cuisine);
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(recipe);
        dest.writeParcelable(image, flags);
    }
}
