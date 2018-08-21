package com.rockspin.androiddevtest

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_ev.view.*

class EVActivityAdapter constructor(
    context: Context
) : RecyclerView.Adapter<EVActivityAdapter.ViewHolder>() {

    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    private var cosmonautActivityList: List<CosmonautActivity> = emptyList()

    fun setCosmonautActivityList(cosmonautActivityList: List<CosmonautActivity>) {
        this.cosmonautActivityList = cosmonautActivityList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = mInflater.inflate(R.layout.list_item_ev, parent, false)

        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (purpose) = cosmonautActivityList[position]

        holder.itemView.textView.text = purpose
    }

    override fun getItemCount(): Int {
        return cosmonautActivityList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
