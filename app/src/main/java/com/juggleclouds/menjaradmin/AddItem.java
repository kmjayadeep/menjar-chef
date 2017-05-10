package com.juggleclouds.menjaradmin;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

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

    @BindView(R.id.et_cat)
    EditText itemCategory;

    @BindView(R.id.et_desc)
    EditText itemDesc;

    @BindView(R.id.addImg)
    Button addImage;

    @BindView(R.id.upimage)
    ImageView upimage;

    private static final int RESULT_LOAD_IMAGE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.addImg)
    public void getImage()
    {
        Intent galleryIntent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent,RESULT_LOAD_IMAGE);
        Bitmap image=((BitmapDrawable)upimage.getDrawable()).getBitmap();
        image=Bitmap.createScaledBitmap(image,300,300,true);
    }
    @OnClick(R.id.saveItem)
    public void saveItem()
    {

    }

}
