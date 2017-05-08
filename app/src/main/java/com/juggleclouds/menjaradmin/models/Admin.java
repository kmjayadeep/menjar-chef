package com.juggleclouds.menjaradmin.models;

/**
 * Created by jayadeep on 5/9/17.
 */

public class Admin {
    public int id;
    public String name, pin, adminType;

    public boolean isManager(){
        return adminType.equals("MANAGER");
    }

    public boolean isChef(){
        return adminType.equals("CHEF");
    }

    public boolean isWaiter(){
        return adminType.equals("WAITER");
    }
}
