package com.eyasumulugeta.pyf.activities.activities;


import android.content.Intent;

import android.os.AsyncTask;
import android.os.Bundle;

import android.text.TextUtils;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import com.eyasumulugeta.pyf.R;
import com.eyasumulugeta.pyf.activities.base.BaseActivity;
import com.eyasumulugeta.pyf.activities.controllers.Session;
import com.eyasumulugeta.pyf.activities.database.DBHelper;
import com.eyasumulugeta.pyf.activities.network.Api;

public class SignInActivity extends BaseActivity {
    private EditText usernameInput;
    private EditText passwordInput;
    private Button signInButton, signUpButton;
    String username;
    DBHelper db;
    Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        db = new DBHelper(this);
        session = new Session(this);
        // Retrieve instances
        usernameInput = (EditText) findViewById(R.id.etUsername);
        passwordInput = (EditText) findViewById(R.id.etPassword);
        signInButton = (Button) findViewById(R.id.bLogin);
        signInButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                login();
            }

        });
        signUpButton = (Button) findViewById(R.id.btnSignUp);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
            }
        });
    }

    private void login() {

        // Retrieve the email and password

       username = usernameInput.getText().toString().trim();

        String password = passwordInput.getText().toString().trim();


        // Validate email address first

        if (TextUtils.isEmpty(username)) {
            usernameInput.setError("Please enter username");
            usernameInput.requestFocus();
            return;
        }


        // Validate password address first

        else if (TextUtils.isEmpty(password)) {

            passwordInput.setError("Please enter a password ");

            passwordInput.requestFocus();

            return;

        } else if (!(TextUtils.isEmpty(username)) && !(TextUtils.isEmpty(password))) {
            boolean user = db.getUser(username, password);
            if (!db.isUserExist())
                toast("Wrong username/password");
            if (user) {

            }
        }
        new SignInTask().execute(username, password);
    }

    private class SignInTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String username = params[0];
            String password = params[1];
            try {
                //return Api.RESULT_OK; test withouht registration with any username & password it will open
                return Api.userLogIn(username, password); //this line of code authenticate the credential by sending it to the server.
            } catch (Exception e) {
                return Api.createError(e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(String s) {
            if (s.startsWith(Api.RESULT_OK)) {
              //  String message = Api.getError(s);

                session.setLoggedIn(true);
                Intent intent = new Intent(SignInActivity.this, LeftNavigationActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
                finish();

                //toast(s);
            } else {
              toast("Log in failed");
            }
        }
    }


}
