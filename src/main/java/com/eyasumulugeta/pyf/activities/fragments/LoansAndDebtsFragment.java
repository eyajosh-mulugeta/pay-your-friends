package com.eyasumulugeta.pyf.activities.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eyasumulugeta.pyf.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoansAndDebtsFragment extends Fragment {


    public LoansAndDebtsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_loans_and_debts, container, false);
    }

}