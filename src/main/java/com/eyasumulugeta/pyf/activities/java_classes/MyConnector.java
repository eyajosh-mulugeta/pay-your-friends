package com.eyasumulugeta.pyf.activities.java_classes;

/**
 * Created by Jo on 5/19/2017.
 */

public interface MyConnector {
    public void getValuesFromFragment1(String firstName, String lastName, String phoneNumber, String emailAddress, String country, String city);

    public void getValuesFromFragment2(String username, String password, String bank, String accountNumber);

    public void statusFragment1(String status);

    public void checkIfEmpty();
}
