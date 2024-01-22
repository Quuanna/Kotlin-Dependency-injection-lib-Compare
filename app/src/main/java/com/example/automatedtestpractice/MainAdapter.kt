package com.example.automatedtestpractice

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView
import com.example.automatedtestpractice.data.ListItemType
import com.example.automatedtestpractice.databinding.ItemTextLayoutBinding

class MainAdapter(private val list: Array<ListItemType>) :
    RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    private lateinit var onGetItemDataListener: OnGetItemDataListener

    interface OnGetItemDataListener {
        fun onCheckedChanged(type: ListItemType, isOpen: Boolean)
    }

    fun addOnClickEventListener(onGetItemData: OnGetItemDataListener) {
        onGetItemDataListener = onGetItemData
    }

    override fun getItemCount(): Int = list.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutView = ItemTextLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }


    inner class MyViewHolder(private val layoutView: ItemTextLayoutBinding) :
        RecyclerView.ViewHolder(layoutView.root) {

        fun bind(type: ListItemType) {
            layoutView.tvTitle.text = type.name
            layoutView.switchCompat.setOnCheckedChangeListener { _, boolean ->
                layoutView.switchCompat.text = if (boolean) "晴天" else "雨天"
                onGetItemDataListener.onCheckedChanged(type, boolean)
            }
        }
    }
}