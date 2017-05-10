package com.juggleclouds.menjaradmin.models;

import java.io.Serializable;

/**
 * Created by jayadeep on 5/9/17.
 */

public class Item implements Serializable{

    public int id;
    public String name;
    public int price;
    public String category;
    public String subCategory;
    public String description;
    public boolean availability;
    public String image;

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
