package com.eyasumulugeta.pyf.activities.controllers;


import com.eyasumulugeta.pyf.activities.models.User;

public class Controllers {

    public static UserController userController;

    public static void initialize() {
        userController = new UserController(User.TABLE);
    }
}
