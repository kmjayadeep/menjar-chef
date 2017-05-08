package com.juggleclouds.menjaradmin.models;

/**
 * Created by jayadeep on 5/9/17.
 */

public class Item {

    public int id;
    public String name;
    public int price;
    public String category;
    public String subCategory;
    public String description;
    public int availability;


    @Override
    public String toString() {
        return id + " " + name + " ";
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
