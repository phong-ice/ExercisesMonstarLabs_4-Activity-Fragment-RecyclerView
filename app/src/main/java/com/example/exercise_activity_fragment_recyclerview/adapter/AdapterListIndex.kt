package com.example.exercise_activity_fragment_recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_activity_fragment_recyclerview.databinding.ItemListIndexBinding
import com.example.exercise_activity_fragment_recyclerview.model.Index

class AdapterListIndex(var indexs: MutableList<Index>) :
    RecyclerView.Adapter<AdapterListIndex.ViewHolder>() {
    class ViewHolder(view: ItemListIndexBinding) : RecyclerView.ViewHolder(view.root) {
        var tv_name = view.tvName
        var tv_address = view.tvAddress
        var tv_time = view.tvTime
        var tv_price = view.tvPrice
        var tv_growth = view.tvGrowth
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemListIndexBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_name.text = indexs[position].name
        holder.tv_address.text = indexs[position].address
        holder.tv_time.text = indexs[position].time
        holder.tv_price.text = indexs[position].price.toString()
        holder.tv_growth.text = indexs[position].oscillate
    }

    override fun getItemCount(): Int {
        return indexs.size
    }
}