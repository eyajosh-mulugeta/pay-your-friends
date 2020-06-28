package com.eyasumulugeta.pyf.activities.network;

import org.json.JSONException;
import org.json.JSONObject;

public final class Api {

    public static final String RESULT_OK = "OK";
    public static final String RESULT_ERROR = "ERROR";

    private static final String BASE_URL = "http://localhost:8000/user/";
    private static final String GET_TALENT_URL = BASE_URL + "signin";
    private static final String TALENT_SIGNUP_URL = BASE_URL + "signup";

    // Connect to API and retrieve information/status
    public static boolean checkApi() {
        try {
            String text = Loader.get(BASE_URL);
            return parseForStatus(text);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean parseForStatus(String text) throws JSONException {
        // Create a root object containing all the JSON text
        JSONObject root = new JSONObject(text);
        // Retrieve api_status flag
        String status = root.getString("api_status");
        return status.equals("running");
    }


    public static String userLogIn(String username, String password) throws Exception {
        // create object with the attributes
        JSONObject object = new JSONObject();
        object.put("username", username);
        object.put("password", password);

        String text = Loader.post(object, GET_TALENT_URL);

        // Parse the response to a JSONObject
        JSONObject root = new JSONObject(text);
        root = root.getJSONObject("user");
        // Check if there is email present
        if (root.has("username")) {
            String returnedUsername = root.getString("username");

            // check if the returned email is same as sent email
            if (returnedUsername.equals(username)) {
                return RESULT_OK;
            } else {
                return createError("The returned username is invalid");
            }
        } else {
            // signIn failed
            String message = root.getString("message");
            return createError(message);
        }
    }


    public static String registerTalent(String firstName, String lastName, String phoneNumber,
                                        String emailAddress, String country, String city,
                                        String username, String password, String bank, String accountNumber)
            throws Exception {
        // create object with the attributes
        JSONObject object = new JSONObject();
        object.put("firstname", firstName);
        object.put("lastname", lastName);
        object.put("phone_number", phoneNumber);
        object.put("email", emailAddress);
        object.put("country", country);
        object.put("city", city);
        object.put("username", username);
        object.put("password", password);
        object.put("bank_name", bank);
        object.put("bank_account", accountNumber);

        String text = Loader.post(object, TALENT_SIGNUP_URL);

        // Parse the response to a JSONObject
        JSONObject root = new JSONObject(text);

        // Check if there is email present
        if (root.has("username")) {
            String returnedEmail = root.getString("username");

            // check if the returned email is same as sent email
            if (returnedEmail.equals(username)) {
                return RESULT_OK;
            } else {
                return createError("The returned username is invalid");
            }
        } else {
            // signup failed
            String message = root.getString("message");
            return createError(message);
        }
    }

    public static String createError(String message) {
        return RESULT_ERROR + ":" + message;
    }

    public static String getError(String message) {
        String[] parts = message.split(":");
        return parts[1];
    }


}