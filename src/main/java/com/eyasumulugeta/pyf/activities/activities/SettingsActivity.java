package com.eyasumulugeta.pyf.activities.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.eyasumulugeta.pyf.R;
import com.eyasumulugeta.pyf.activities.base.BaseActivity;


public class SettingsActivity extends BaseActivity implements View.OnClickListener{

    private TextView txtChangePassword;
    private ImageView imgChangePassword, backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        txtChangePassword= (TextView) findViewById(R.id.txtChangePassword);
        txtChangePassword.setOnClickListener(this);

        backArrow= (ImageView) findViewById(R.id.backArrow);
        backArrow.setOnClickListener(this);

        imgChangePassword= (ImageView) findViewById(R.id.imgChangePassword);
        imgChangePassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txtChangePassword:
                startActivity(new Intent(SettingsActivity.this, ChangePasswordActivity.class));
                finish();
                break;
            case R.id.imgChangePassword:
                startActivity(new Intent(SettingsActivity.this, ChangePasswordActivity.class));
                finish();
                break;
            case R.id.backArrow:
                startActivity(new Intent(SettingsActivity.this, LeftNavigationActivity.class));
                finish();
                break;
        }
    }
}
