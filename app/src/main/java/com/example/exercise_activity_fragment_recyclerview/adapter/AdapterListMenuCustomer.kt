package com.example.exercise_activity_fragment_recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_activity_fragment_recyclerview.databinding.ItemMenuCustomer2Binding
import com.example.exercise_activity_fragment_recyclerview.databinding.ItemMenuCustomerBinding
import com.example.exercise_activity_fragment_recyclerview.databinding.ItemMenuCustomerHeaderBinding
import com.example.exercise_activity_fragment_recyclerview.model.ItemMenuCustomer

class AdapterListMenuCustomer(var listItemMenus: MutableList<ItemMenuCustomer>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        val TYPE_1 = "type_1"
        val TYPE_2 = "type_2"
        val HEADER = "header"
    }

    private val VIEW_TYPE_1 = 1
    private val VIEW_TYPE_2 = 2
    private val VIEW_HEADER = 3

    class ViewHolder1(_binding: ItemMenuCustomerBinding) : RecyclerView.ViewHolder(_binding.root) {
        var img1 = _binding.imgItemListMenu1
        var tv1 = _binding.tvItemListMenu1
    }

    class ViewHolder2(_binding: ItemMenuCustomer2Binding) : RecyclerView.ViewHolder(_binding.root) {
        var img2 = _binding.imgItemListMenu2
        var tv2 = _binding.tvItemListMenu2
    }

    class ViewHolder3(_binding: ItemMenuCustomerHeaderBinding) :
        RecyclerView.ViewHolder(_binding.root) {
        var tv_header = _binding.tvHeader
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_1 -> ViewHolder1(
                ItemMenuCustomerBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            VIEW_TYPE_2 -> ViewHolder2(
                ItemMenuCustomer2Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> ViewHolder3(
                ItemMenuCustomerHeaderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            VIEW_TYPE_1 -> {
                var viewHolder1: ViewHolder1 = holder as ViewHolder1
                viewHolder1.img1.setImageResource(listItemMenus[position].img)
                viewHolder1.tv1.text = listItemMenus[position].title
            }
            VIEW_TYPE_2 -> {
                var viewHolder2: ViewHolder2 = holder as ViewHolder2
                viewHolder2.img2.setImageResource(listItemMenus[position].img)
                viewHolder2.tv2.text = listItemMenus[position].title
            }
            VIEW_HEADER -> {
                var viewHolder3: ViewHolder3 = holder as ViewHolder3
                viewHolder3.tv_header.text = listItemMenus[position].title
            }
        }
    }

    override fun getItemCount(): Int {
        return listItemMenus.size
    }

    override fun getItemViewType(position: Int): Int {
        var itemMenu = listItemMenus[position]
        return when (itemMenu.type) {
            TYPE_1 -> VIEW_TYPE_1
            TYPE_2 -> VIEW_TYPE_2
            else -> return VIEW_HEADER
        }
    }
}