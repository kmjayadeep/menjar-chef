package com.juggleclouds.menjaradmin;

import android.app.Application;

import com.juggleclouds.menjaradmin.models.Admin;
import com.juggleclouds.menjaradmin.utils.network.ApiClient;
import com.juggleclouds.menjaradmin.utils.network.RestApiInterface;

/**
 * Created by jayadeep on 5/9/17.
 */

public class Global extends Application {
    public static final String BASE_URL = "http://192.168.43.155:3000/";
    public static Admin admin;
    public static RestApiInterface apiClient = ApiClient.getClient();
}
