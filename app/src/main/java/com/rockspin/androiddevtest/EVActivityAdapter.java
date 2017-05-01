package com.rockspin.androiddevtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EVActivityAdapter extends RecyclerView.Adapter<EVActivityAdapter.ViewHolder> {

    private final LayoutInflater mInflater;
    private List<CosmonautActivity> mCosmonautActivityList;
    private boolean m_ascending = true;

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

    public void setSortOrder( boolean ascending )
    {
        m_ascending = ascending;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View rootView = mInflater.inflate(R.layout.list_item_ev, parent, false);

        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        int index   = position;
        if( ! m_ascending )
            index   = mCosmonautActivityList.size() - 1 - position;

        final CosmonautActivity cosmonautActivity = mCosmonautActivityList.get( index );

        holder.tvName.setText(cosmonautActivity.getPurpose());

        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
        holder.tvDate.setText( format.format( cosmonautActivity.getDate() ) );
    }

    @Override
    public int getItemCount() {
        return mCosmonautActivityList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvDate;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_patent_name);
            tvDate = (TextView) itemView.findViewById(R.id.tv_date);
        }
    }
}
