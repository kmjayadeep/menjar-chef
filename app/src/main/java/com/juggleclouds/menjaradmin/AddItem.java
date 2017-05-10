package com.juggleclouds.menjaradmin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddItem extends AppCompatActivity {
    @BindView(R.id.et_name)
    EditText itemName;
    @BindView(R.id.et_cost)
    EditText itemPrice;
    @BindView(R.id.et_avail)
    EditText itemAvail;
    @BindView(R.id.et_cost)
    EditText itemCategory;
    @BindView(R.id.et_desc)
    EditText itemDesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.img)
    public void getImage()
    {

    }
    @OnClick(R.id.addItem)
    public void addItem()
    {

    }
}
