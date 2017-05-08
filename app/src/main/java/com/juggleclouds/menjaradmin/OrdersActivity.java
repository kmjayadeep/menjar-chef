package com.juggleclouds.menjaradmin;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.juggleclouds.menjaradmin.adapters.OrdersAdapter;
import com.juggleclouds.menjaradmin.models.Order;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrdersActivity extends AppCompatActivity {

    List<Order> orders = new ArrayList<>();

    @BindView(R.id.orders)
    ListView lvOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        ButterKnife.bind(this);
        lvOrders.setAdapter(new OrdersAdapter(this, orders));
        refreshOrders();
    }

    public void refreshOrders() {
        if (this.isDestroyed())
            return;
        if (Global.admin.isChef())
            Global.apiClient.getPlacedOrders().enqueue(orderCallback);
        else
            Global.apiClient.getReadyOrders().enqueue(orderCallback);

    }

    Callback<List<Order>> orderCallback = new Callback<List<Order>>() {
        @Override
        public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
            if (response.isSuccessful()) {
//                Log.i("orders plced", response.body().toString());
                orders = response.body();
                refreshLists();
            } else {
                Toast.makeText(OrdersActivity.this, "Unable to fetch orders", Toast.LENGTH_SHORT).show();
//                Log.e("err", response.errorBody().toString());
            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    refreshOrders();
                }
            }, 4000);
        }

        @Override
        public void onFailure(Call<List<Order>> call, Throwable t) {
            Toast.makeText(OrdersActivity.this, "Unable to connect", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    refreshOrders();
                }
            }, 4000);
        }
    };

    private void refreshLists() {
        OrdersAdapter adapter = (OrdersAdapter) lvOrders.getAdapter();
        adapter.refresh(orders);
    }

}
