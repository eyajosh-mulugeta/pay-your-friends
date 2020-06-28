package com.eyasumulugeta.pyf.activities.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.eyasumulugeta.pyf.R;
import com.eyasumulugeta.pyf.activities.base.BaseActivity;


public class ChangePasswordActivity extends BaseActivity {
private ImageView backArrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        backArrow= (ImageView) findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChangePasswordActivity.this, SettingsActivity.class));
                finish();
            }
        });
    }
}
