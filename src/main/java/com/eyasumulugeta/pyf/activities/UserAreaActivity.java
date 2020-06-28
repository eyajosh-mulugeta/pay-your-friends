package com.eyasumulugeta.pyf.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.eyasumulugeta.pyf.R;
import com.eyasumulugeta.pyf.activities.base.BaseActivity;

public class UserAreaActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);


        final EditText etAge = (EditText) findViewById(R.id.etAge);
        final TextView welcomeMessage = (TextView) findViewById(R.id.tvWelcomeMessage);
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);

        Intent intent = new Intent();

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");
        String username = extras.getString("username");
        int age = extras.getInt("age", -1);

        String messg = "username = "+username+" & age = "+age+" name = "+name;
        Log.d("yes", messg);

        String message = name + ", welcome to your user area.";

                welcomeMessage.setText(message);
        etUsername.setText(username);

        etAge.setText( age +"");

    }
}
