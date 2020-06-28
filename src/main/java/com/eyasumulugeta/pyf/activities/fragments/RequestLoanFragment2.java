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

public class RequestLoanFragment2 extends Fragment implements View.OnClickListener {
    private MyConnector myConnector;
    private Button signUp;
    private Spinner BANK_SPINNER;
    private EditText USERNAME, PASSWORD, CONFIRM_PASSWORD, ACCOUNT_NUMBER;
    private String username, password, confirmPassword, bank, accountNumber;

    public RequestLoanFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment2_request_loan, container, false);


        return root;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        myConnector = (MyConnector) context;
    }

    @Override
    public void onClick(View v) {
    }
}