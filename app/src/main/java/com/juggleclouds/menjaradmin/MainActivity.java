package com.juggleclouds.menjaradmin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.orders)
    Button bOrders;

    @BindView(R.id.edit)
    Button bEdit;

    @BindView(R.id.statistics)
    Button bStats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Menjar");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        if (!Global.admin.isManager())
            bStats.setVisibility(View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                Global.admin = null;
                startActivity(new Intent(this, LoginActivity.class));
                this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.orders)
    public void order() {
        startActivity(new Intent(this, OrdersActivity.class));
    }

}
