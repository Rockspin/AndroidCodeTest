package com.rockspin.androiddevtest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: EVActivityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapter = EVActivityAdapter(this)
        recyclerView.adapter = adapter

        val response = MyApplication.apiService.evList.execute()
        val cosmonautActivityList = response.body()
        adapter.setCosmonautActivityList(cosmonautActivityList)
    }
}
