package com.rockspin.androiddevtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private EVActivityAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mAdapter = new EVActivityAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        final Response<List<CosmonautActivity>> response = MyApplication.getAPIService().getEVList().execute();
        final List<CosmonautActivity> cosmonautActivityList = response.body();
        mAdapter.setCosmonautActivityList(cosmonautActivityList);
    }
}
