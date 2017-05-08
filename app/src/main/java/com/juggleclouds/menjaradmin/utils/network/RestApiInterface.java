package com.juggleclouds.menjaradmin.utils.network;

import com.juggleclouds.menjaradmin.models.Admin;
import com.juggleclouds.menjaradmin.models.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by jayadeep on 5/9/17.
 */

public interface RestApiInterface {

    @POST("/admin/login")
    Call<Admin> login(@Body Admin admin);

    @GET("/order/placed")
    Call<List<Order>> getPlacedOrders();

}