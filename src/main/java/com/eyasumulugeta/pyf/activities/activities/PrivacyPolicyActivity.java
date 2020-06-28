package com.eyasumulugeta.pyf.activities.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.eyasumulugeta.pyf.R;


public class PrivacyPolicyActivity extends AppCompatActivity implements View.OnClickListener {
    private WebView webView;
    private ImageView backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);

        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://techfarmethiopia.blogspot.com/2017/05/privacy-policy.html");

        backArrow = (ImageView) findViewById(R.id.backArrow);
        backArrow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backArrow:
                startActivity(new Intent(this, AboutActivity.class));
                finish();
                break;

        }
    }
}
