package com.example.mydiffadapter.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mydiffadapter.BR
import com.example.mydiffadapter.R
import com.example.mydiffadapter.base.BaseBindingViewHolder
import com.example.mydiffadapter.databinding.RowItemNationBinding
import com.example.mydiffadapter.model.NationUI

class NationViewHolder(
    private val binding: RowItemNationBinding,
    private val onClickItem: (NationUI) -> Unit,
) : BaseBindingViewHolder<NationUI>(binding) {

    override fun bind(item: NationUI) {
        binding.apply {
            setVariable(BR.model, item)
            if (item.isCheck) {
                binding.imgCheck.visibility = View.VISIBLE
            } else {
                binding.imgCheck.visibility = View.GONE
            }
            root.setOnClickListener {
                onClickItem.invoke(item)
                executePendingBindings()
            }
        }
    }

    companion object {
        fun create(parent: ViewGroup, onClickItem: (NationUI) -> Unit): NationViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.row_item_nation, parent, false)
            val binding = RowItemNationBinding.bind(view)
            return NationViewHolder(binding, onClickItem)
        }
    }

}
