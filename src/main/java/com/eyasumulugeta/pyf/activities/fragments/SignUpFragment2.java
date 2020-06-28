package com.eyasumulugeta.pyf.activities.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.eyasumulugeta.pyf.R;
import com.eyasumulugeta.pyf.activities.java_classes.MyConnector;

public class SignUpFragment2 extends Fragment implements View.OnClickListener {
    private MyConnector myConnector;
    private Button signUp;
    private Spinner BANK_SPINNER;
    private EditText USERNAME, PASSWORD, CONFIRM_PASSWORD, ACCOUNT_NUMBER;
    private String username, password, confirmPassword, bank, accountNumber;

    public SignUpFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_sign_up2, container, false);
        USERNAME = (EditText) root.findViewById(R.id.username);
        PASSWORD = (EditText) root.findViewById(R.id.password);
        CONFIRM_PASSWORD = (EditText) root.findViewById(R.id.confirmPassword);
        ACCOUNT_NUMBER = (EditText) root.findViewById(R.id.accountNumber);
        BANK_SPINNER = (Spinner) root.findViewById(R.id.bankSpinner);
        signUp = (Button) root.findViewById(R.id.btnSignUp);
        signUp.setOnClickListener(this);


        return root;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        myConnector = (MyConnector) context;
    }

    @Override
    public void onClick(View v) {
        username = USERNAME.getText().toString();
        password = PASSWORD.getText().toString();
        confirmPassword = CONFIRM_PASSWORD.getText().toString();
        accountNumber = ACCOUNT_NUMBER.getText().toString();
        bank = BANK_SPINNER.getSelectedItem().toString();
        switch (v.getId()) {
            case R.id.btnSignUp:
                if (password.equals(confirmPassword)) {
                    myConnector.getValuesFromFragment2(username, password, bank, accountNumber);
                }

                break;
        }
    }
}