package com.eyasumulugeta.pyf.activities.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.eyasumulugeta.pyf.R;
import com.eyasumulugeta.pyf.activities.base.BaseActivity;


public class AboutActivity extends BaseActivity implements View.OnClickListener {

    private ImageView backArrow;
    private TextView privacyPolicy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        backArrow = (ImageView) findViewById(R.id.backArrow);
        backArrow.setOnClickListener(this);

        privacyPolicy = (TextView) findViewById(R.id.privacyPolicy);
        privacyPolicy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backArrow:
                startActivity(new Intent(this, LeftNavigationActivity.class));
                finish();
                break;
            case R.id.privacyPolicy:
                startActivity(new Intent(this, PrivacyPolicyActivity.class));
                finish();
                break;
        }
    }
}
