package com.juggleclouds.menjaradmin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.juggleclouds.menjaradmin.adapters.CatalogAdapter;
import com.juggleclouds.menjaradmin.models.Item;
import com.juggleclouds.menjaradmin.utils.network.ApiClient;
import com.juggleclouds.menjaradmin.utils.network.RestApiInterface;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Catalog extends AppCompatActivity implements CatalogAdapter.ItemClickListener{
    @BindView(R.id.rv_items)
    RecyclerView rvItems;
    CatalogAdapter catalogAdapter;
    List<Item> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        ButterKnife.bind(this);
        items=new ArrayList<>();
//        Item item=new Item();
//        item.id=1;
//        item.name="Chick";
//        item.price=150;
//        items.add(item);
        getItems();
    }
    public void getItems()
    {
        RestApiInterface service = ApiClient.getClient();
        Call<List<Item>> call = service.getCatalogItems();
        final ProgressDialog dialog = new ProgressDialog(Catalog.this);
        dialog.setCancelable(false);
        dialog.setMessage("Loading List");
        dialog.show();
        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                List<Item> catalogItems = (List<Item>) response.body();
                Toast.makeText(getApplicationContext(),"Fetch Success",Toast.LENGTH_SHORT).show();
                items=catalogItems;
                catalogAdapter = new CatalogAdapter(getApplicationContext(),items);
                rvItems.setAdapter(catalogAdapter);
                GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
                rvItems.setLayoutManager(layoutManager);
                catalogAdapter.setClickListener(Catalog.this);
                catalogAdapter.notifyDataSetChanged();
                dialog.dismiss();
            }
            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                dialog.dismiss();
                Log.d("FailItems",t.toString());
                Toast.makeText(getApplicationContext(),"Unable to Load",Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public void onClick(View view, int position) {
        Item item=items.get(position);
        Intent intent=new Intent(Catalog.this,EditCatalog.class);
        intent.putExtra("Item",item);
        startActivity(intent);
    }
    @OnClick(R.id.addItem)
    public void addItem()
    {
        Intent intent=new Intent(Catalog.this,AddItem.class);
        startActivity(intent);
    }
}
