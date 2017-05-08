package com.juggleclouds.menjaradmin.utils.network;

import com.juggleclouds.menjaradmin.Global;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jayadeep on 5/9/17.
 */

public class ApiClient {
    static RestApiInterface apiClient;
    public static RestApiInterface getClient() {
        if (apiClient==null) {
            apiClient = new Retrofit.Builder()
                    .baseUrl(Global.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(RestApiInterface.class);
        }
        return apiClient;
    }
}