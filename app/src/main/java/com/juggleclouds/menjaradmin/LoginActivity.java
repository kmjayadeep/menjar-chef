package com.juggleclouds.menjaradmin;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.juggleclouds.menjaradmin.models.Admin;

import javax.microedition.khronos.opengles.GL;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.adminType)
    RadioGroup rgAdminType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login)
    public void login(View v) {
        Admin admin = new Admin();
        admin.name = ((TextInputLayout) findViewById(R.id.username)).getEditText().getText().toString();
        admin.pin = ((TextInputLayout) findViewById(R.id.pin)).getEditText().getText().toString();
        switch (rgAdminType.getCheckedRadioButtonId()) {
            case R.id.manager:
                admin.adminType = "MANAGER";
                break;
            case R.id.chef:
                admin.adminType = "CHEF";
                break;
            case R.id.waiter:
                admin.adminType = "WAITER";
                break;
        }
        Global.apiClient.login(admin).enqueue(new Callback<Admin>() {
            @Override
            public void onResponse(Call<Admin> call, Response<Admin> response) {
                if (response.isSuccessful()) {
                    Global.admin = response.body();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    LoginActivity.this.finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid Login", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Admin> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Unable to connect to server", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
