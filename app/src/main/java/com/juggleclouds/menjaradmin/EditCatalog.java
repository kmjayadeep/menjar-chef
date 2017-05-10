package com.juggleclouds.menjaradmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.juggleclouds.menjaradmin.models.Item;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditCatalog extends AppCompatActivity {
    @BindView(R.id.tv_name)
    TextView itemName;
    @BindView(R.id.tv_desc)
    TextView itemDesc;
    @BindView(R.id.et_cost)
    EditText itemPrice;
    @BindView(R.id.et_avail)
    EditText itemAvail;
    @BindView(R.id.iv_item)
    ImageView ivItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_catalog);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        Item item = (Item) intent.getSerializableExtra("Item");
        itemName.setText(item.name);
        itemPrice.setText(String.valueOf(item.price));
        if(item.description!=null)
            itemDesc.setText(item.description);
        String url=Global.BASE_URL;
        Picasso.with(getApplicationContext()).load(url.substring(0,url.length()-1)+item.image).fit().error(R.drawable.sample).into(ivItem);
        if(item.availability)
        {
            itemAvail.setText("Yes");
        }
        else {
            itemAvail.setText("No");
        }
    }
    @OnClick(R.id.update)
    public void update(){
        int price=Integer.parseInt(itemPrice.getText().toString());
        boolean avail=Boolean.parseBoolean(itemAvail.getText().toString());
    }
    @OnClick(R.id.delete)
    public void delete()
    {

    }
}
