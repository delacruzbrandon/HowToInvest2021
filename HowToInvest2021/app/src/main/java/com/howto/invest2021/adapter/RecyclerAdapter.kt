package com.howto.invest2021.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.howto.invest2021.R
import com.howto.invest2021.callback.OnAdapterClickListener
import com.howto.invest2021.databinding.ViewHolderRecyclerBinding
import com.howto.invest2021.model.DetailsModel
import com.howto.invest2021.view.HomeFragment

class RecyclerAdapter(var clickListener: OnAdapterClickListener ,var context: Context, var detailsList: List<DetailsModel>): RecyclerView.Adapter<RecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val viewBinding: ViewHolderRecyclerBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.view_holder_recycler, parent, false)
        return RecyclerViewHolder(viewBinding, clickListener)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.viewBinding.detailsModel = detailsList[position]
    }

    override fun getItemCount(): Int {
        return detailsList.size
    }
}