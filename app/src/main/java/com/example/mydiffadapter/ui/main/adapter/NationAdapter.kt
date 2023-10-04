package com.example.mydiffadapter.ui.main.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.mydiffadapter.base.BaseBindingAdapter
import com.example.mydiffadapter.model.NationUI

class NationAdapter(var onClickItem: (NationUI) -> Unit) :
    BaseBindingAdapter<NationUI, NationViewHolder>(COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NationViewHolder {
        return NationViewHolder.create(parent, onClickItem)
    }

    override fun setData(data: List<NationUI>) {
        submitList(data)
    }

    override fun onBindViewHolder(holder: NationViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<NationUI>() {
            override fun areItemsTheSame(oldItem: NationUI, newItem: NationUI): Boolean {
                return oldItem.code == newItem.code
            }

            override fun areContentsTheSame(oldItem: NationUI, newItem: NationUI): Boolean {
                return oldItem == newItem
            }

        }
    }

}