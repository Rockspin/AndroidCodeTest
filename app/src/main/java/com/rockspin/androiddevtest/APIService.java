package com.rockspin.androiddevtest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    /**
     * Perform a call to fetch a list of Extra-Vehicular Cosmonaut Activity starting from 1965
     * @return The Retrofit Call
     */
    @GET("9kcy-zwvn.json?$order=date&$limit=20")
    Call<List<CosmonautActivity>> getEVList();
}
