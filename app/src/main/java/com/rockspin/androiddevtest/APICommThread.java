package com.rockspin.androiddevtest;

import android.content.Intent;

import java.util.List;

import retrofit2.Response;

/**
 * Created by SG on 08.01.2017 г..
 */
public class APICommThread extends Thread
{
    @Override
    public	void	run()
    {
        try
        {
            Response<List<CosmonautActivity>>   response        = MyApplication.getAPIService().getEVList().execute();
            List<CosmonautActivity>             activityList    = response.body();
            MyApplication.instance().setCosmonautActivities( activityList );

            //  Send notification to the MainActivity to update the recycler view data.

            Intent  broadcastUpdateData  = new Intent( MyApplication.BROADCAST_UPDATE_DATA_HANDLER );
            MyApplication.instance().sendBroadcast( broadcastUpdateData );
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}
