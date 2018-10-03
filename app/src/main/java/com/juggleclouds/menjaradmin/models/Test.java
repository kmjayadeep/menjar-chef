package com.juggleclouds.menjaradmin.models;

/**
 * Created by amrithm98 on 3/10/18.
 */

public class Tested {
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
