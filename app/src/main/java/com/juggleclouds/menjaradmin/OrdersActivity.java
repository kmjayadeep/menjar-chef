package com.juggleclouds.menjaradmin;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import com.juggleclouds.menjaradmin.models.Order;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrdersActivity extends AppCompatActivity {

    List<Order> placedOrders = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        refreshPlacedOrders();
    }

    public void refreshPlacedOrders() {
        Global.apiClient.getPlacedOrders().enqueue(orderCallback);
    }

    Callback<List<Order>> orderCallback = new Callback<List<Order>>() {
        @Override
        public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
            if (response.isSuccessful()) {
//                Log.i("orders plced", response.body().toString());
                placedOrders = response.body();
            } else {
                Toast.makeText(OrdersActivity.this, "Unable to fetch orders", Toast.LENGTH_SHORT).show();
                Log.e("err", response.errorBody().toString());
            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    refreshPlacedOrders();
                }
            }, 4000);
        }

        @Override
        public void onFailure(Call<List<Order>> call, Throwable t) {
            Toast.makeText(OrdersActivity.this, "Unable to connect", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    refreshPlacedOrders();
                }
            }, 4000);
        }
    };

}
