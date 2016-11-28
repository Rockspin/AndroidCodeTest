package com.rockspin.androiddevtest;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApplication extends Application {

    private static APIService sAPIService;

    @Override
    public void onCreate() {
        super.onCreate();

        final Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://data.nasa.gov/resource/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        sAPIService = retrofit.create(APIService.class);
    }

    public static APIService getAPIService() {
        return sAPIService;
    }
}
