package com.juggleclouds.menjaradmin.utils.network;

import com.juggleclouds.menjaradmin.models.Admin;
import com.juggleclouds.menjaradmin.models.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by jayadeep on 5/9/17.
 */

public interface RestApiInterface {

    @POST("/admin/login")
    Call<Admin> login(@Body Admin admin);

    @GET("/order/placed")
    Call<List<Order>> getPlacedOrders();

    @GET("/order/ready")
    Call<List<Order>> getReadyOrders();

    @FormUrlEncoded
    @POST("/order/status/{id}")
    Call<Order> changeStatus(@Path("id") int id, @Field("status") String status);

}