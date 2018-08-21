package com.rockspin.androiddevtest

import android.app.Application

import com.google.gson.Gson
import com.google.gson.GsonBuilder

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val gson = GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://data.nasa.gov/resource/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        apiService = retrofit.create(APIService::class.java)
    }

    companion object {
        lateinit var apiService: APIService
            private set
    }
}
