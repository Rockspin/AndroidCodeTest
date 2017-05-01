package com.rockspin.androiddevtest;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApplication extends Application {

    private static APIService sAPIService;
    private static MyApplication s_instance;
    private List<CosmonautActivity> m_cosmonautActivities;

    public static final String	BROADCAST_UPDATE_DATA_HANDLER			= "BROADCAST_UPDATE_DATA_HANDLER";

    public MyApplication()
    {
        s_instance  = this;
    }

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

    public static MyApplication  instance()
    {
        return s_instance;
    }

    public List<CosmonautActivity> getCosmonautActivities() {
        return m_cosmonautActivities;
    }

    public void setCosmonautActivities(List<CosmonautActivity> cosmonautActivities) {
        this.m_cosmonautActivities = cosmonautActivities;
    }
}
