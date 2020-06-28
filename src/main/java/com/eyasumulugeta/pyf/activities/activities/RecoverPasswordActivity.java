package com.eyasumulugeta.pyf.activities.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.eyasumulugeta.pyf.R;
import com.eyasumulugeta.pyf.activities.base.BaseActivity;


public class RecoverPasswordActivity extends BaseActivity implements View.OnClickListener {
private ImageView backArrow;
    private TextView needMoreHelp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_password);

        backArrow = (ImageView) findViewById(R.id.recoverPasswordBackArrow);
        backArrow.setOnClickListener(this);

        needMoreHelp = (TextView) findViewById(R.id.needMoreHelp);
        needMoreHelp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.recoverPasswordBackArrow:
                startActivity(new Intent(this, SignInActivity.class));
                RecoverPasswordActivity.this.finish();
                break;
            case R.id.needMoreHelp:
                startActivity(new Intent(this, SupportActivity.class));
                RecoverPasswordActivity.this.finish();
                break;
            case R.id.btnRecover:
                break;
        }
    }
}
