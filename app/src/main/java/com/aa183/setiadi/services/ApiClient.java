package com.aa183.setiadi.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static Retrofit retrofit;
    public static final String BASE_URL = "https://api-buku.000webhostapp.com/perpusuas/api/";
    public static final String IMG_URL = "https://api-buku.000webhostapp.com/perpusuas/img/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            try {
                retrofit = new Retrofit.Builder().
                        baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            } catch (Exception er) {
                er.printStackTrace();
            }
        }
        return retrofit;
    }

}
