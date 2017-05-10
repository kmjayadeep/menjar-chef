package com.juggleclouds.menjaradmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.juggleclouds.menjaradmin.models.Item;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditCatalog extends AppCompatActivity {
    @BindView(R.id.tv_name)
    TextView itemName;
    @BindView(R.id.tv_cost)
    EditText itemPrice;
    @BindView(R.id.tv_avail)
    EditText itemAvail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_catalog);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        Item item = (Item) intent.getSerializableExtra("Item");
        itemName.setText(item.name);
        itemPrice.setText(String.valueOf(item.price));
        itemAvail.setText(item.availability);
    }
}
