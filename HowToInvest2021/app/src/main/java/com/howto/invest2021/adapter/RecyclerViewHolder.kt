package com.howto.invest2021.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.howto.invest2021.callback.OnAdapterClickListener
import com.howto.invest2021.databinding.ViewHolderRecyclerBinding

class RecyclerViewHolder(itemView: ViewHolderRecyclerBinding, var clickListener: OnAdapterClickListener): RecyclerView.ViewHolder(itemView.root), View.OnClickListener {
    val viewBinding = itemView

    init {
        itemView.root.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        clickListener.onClick(adapterPosition)
    }

}