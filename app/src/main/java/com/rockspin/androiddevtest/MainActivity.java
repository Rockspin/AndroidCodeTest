package com.rockspin.androiddevtest;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private RecyclerView        mRecyclerView   = null;
    private EVActivityAdapter   mAdapter        = null;
    private ProgressDialog      m_loadingDialog = null;
    private AlertDialog         m_alertDialog   = null;

    private FloatingActionButton        m_sortButton    = null;
    private BroadcastDataUpdateReceiver m_brcUpdateData = null;

    private boolean m_ascendingOrder    = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        m_sortButton = (FloatingActionButton) findViewById(R.id.fab_change_sorting);
        m_sortButton.setOnClickListener(this);

        mAdapter = new EVActivityAdapter(this);
        mRecyclerView.setAdapter(mAdapter);


        m_brcUpdateData = new BroadcastDataUpdateReceiver();
        registerReceiver( m_brcUpdateData, new IntentFilter( MyApplication.BROADCAST_UPDATE_DATA_HANDLER ) );

        if( hasInternetConnection() )
        {
            fetchData();
            return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setMessage( getText( R.string.no_net_connection ) );
        builder.setPositiveButton(getText(R.string.retry), new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                m_alertDialog.dismiss();
                fetchData();
            }
        });

        m_alertDialog = builder.create();
        m_alertDialog.setCancelable( false );
        m_alertDialog.show();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        try
        {
            if( m_brcUpdateData != null )
                unregisterReceiver( m_brcUpdateData );
        }
        catch( IllegalArgumentException e )
        {
            e.printStackTrace();
        }
    }

    private boolean hasInternetConnection()
    {
        ConnectivityManager conManager  = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo         netInfo     = conManager.getActiveNetworkInfo();

        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    private void fetchData()
    {
        m_loadingDialog = ProgressDialog.show(MainActivity.this, "", getText(R.string.fetch_data), true);

        APICommThread appCommThread = new APICommThread();
        appCommThread.start();
    }

    @Override
    public void onClick( View v )
    {
        m_ascendingOrder    = ! m_ascendingOrder;

        mAdapter.setSortOrder( m_ascendingOrder );
        mAdapter.notifyDataSetChanged();
    }

    class BroadcastDataUpdateReceiver extends BroadcastReceiver
    {
        @Override
        public void onReceive( Context context, Intent intent )
        {
            m_loadingDialog.dismiss();
            mAdapter.setCosmonautActivityList( MyApplication.instance().getCosmonautActivities() );
        }
    }
}
