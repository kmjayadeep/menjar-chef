package com.juggleclouds.menjaradmin.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jayadeep on 5/9/17.
 */
public class Order {
    public int id;
    public String comments, status;
    public float amount;
    public String table;
    public List<OrderItem> orderItems;

    @Override
    public String toString() {
        return table + " " + amount + " " + orderItems.toString();
    }

    public class OrderItem {
        public Item item;
        public int itemId;
        public int quantity;

        @Override
        public String toString() {
            return item.toString() + " :" + quantity;
        }
    }
}
