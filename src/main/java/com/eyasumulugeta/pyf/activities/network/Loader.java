package com.eyasumulugeta.pyf.activities.network;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Loader {

    public static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");

    public static String get(String url) throws Exception {
        OkHttpClient client = init();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String post(Object data, String url) throws Exception {
        OkHttpClient client = init();
        RequestBody body = RequestBody.create(JSON_MEDIA_TYPE, data.toString());
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    private static OkHttpClient init() {
        OkHttpClient client = new OkHttpClient();
        return client;
    }
}
