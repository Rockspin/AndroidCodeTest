package com.rockspin.androiddevtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rockspin.androiddevtest.R;

import java.util.ArrayList;
import java.util.List;

public class EVActivityAdapter extends RecyclerView.Adapter<EVActivityAdapter.ViewHolder> {

    private final LayoutInflater mInflater;
    private List<CosmonautActivity> mCosmonautActivityList;

    public EVActivityAdapter(Context context) {
        this(context, new ArrayList<CosmonautActivity>());
    }

    public EVActivityAdapter(Context context, List<CosmonautActivity> ideaList) {
        mInflater = LayoutInflater.from(context);
        mCosmonautActivityList = ideaList;
    }

    public void setCosmonautActivityList(List<CosmonautActivity> cosmonautActivityList) {
        mCosmonautActivityList = cosmonautActivityList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View rootView = mInflater.inflate(R.layout.list_item_ev, parent, false);

        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final CosmonautActivity cosmonautActivity = mCosmonautActivityList.get(position);

        holder.tvName.setText(cosmonautActivity.getPurpose());
    }

    @Override
    public int getItemCount() {
        return mCosmonautActivityList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_patent_name);
        }
    }
}
