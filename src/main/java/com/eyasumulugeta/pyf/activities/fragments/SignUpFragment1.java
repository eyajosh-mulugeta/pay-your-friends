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

public class SignUpFragment1 extends Fragment {
    private Spinner countriesSpinner, citiesSpinner;
    private EditText firstName, lastName, phoneNumber, emailAddress;
    private String fName, lName, pNumber, eAddress, countriesSp, citiesSp, status;
    private Button next;
    private MyConnector myConnector;
    View v;

    public SignUpFragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_sign_up1, container, false);
        v = root;
        firstName = (EditText) root.findViewById(R.id.firstName);
        lastName = (EditText) root.findViewById(R.id.lastName);
        phoneNumber = (EditText) root.findViewById(R.id.phoneNumber);
        emailAddress = (EditText) root.findViewById(R.id.emailAddress);
        countriesSpinner = (Spinner) root.findViewById(R.id.countriesSpinner);
        citiesSpinner = (Spinner) root.findViewById(R.id.citiesSpinner);

        next = (Button) root.findViewById(R.id.btnNext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fName = firstName.getText().toString();
                lName = lastName.getText().toString();
                pNumber = phoneNumber.getText().toString();
                eAddress = emailAddress.getText().toString();
                countriesSp = countriesSpinner.getSelectedItem().toString();
                citiesSp = citiesSpinner.getSelectedItem().toString();

                if (!fName.isEmpty() && !lName.isEmpty() && !pNumber.isEmpty() && !eAddress.isEmpty() && !countriesSp.isEmpty() && !citiesSp.isEmpty()) {
                    switch (v.getId()) {
                        case R.id.btnNext:
                            myConnector.getValuesFromFragment1(fName, lName, pNumber, eAddress, countriesSp, citiesSp);
                            status = "change";
                            myConnector.statusFragment1(status);
                            break;
                    }
                } else {
                    status = "stay";
                    myConnector.statusFragment1(status);
                }
            }
        });
        return root;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MyConnector) {
            myConnector = (MyConnector) context;
        }
    }

}