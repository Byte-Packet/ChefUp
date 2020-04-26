package com.example.dashboard;

import android.graphics.Bitmap;
import android.media.Image;

public class Product {

    String cuisine;
    String name;
    String recipe;
    Bitmap image;

    public Product(Bitmap image, String name, String recipe, String cuisine) {
        this.image = image;
        this.name = name;
        this.recipe = recipe;
        this.cuisine = cuisine;
    }

    public Product(String name, String recipe) {
        this.name = name;
        this.recipe = recipe;
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
}
