package com.rockspin.androiddevtest

import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    /**
     * Perform a call to fetch a list of Extra-Vehicular Cosmonaut Activity starting from 1965
     * @return The Retrofit Call
     */
    @get:GET("9kcy-zwvn.json?\$order=date&\$limit=20")
    val evList: Call<List<CosmonautActivity>>
}
