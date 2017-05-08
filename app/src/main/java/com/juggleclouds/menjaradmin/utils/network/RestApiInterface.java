package com.juggleclouds.menjaradmin.utils.network;

import com.juggleclouds.menjaradmin.models.Admin;

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

}