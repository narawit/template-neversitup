package com.kaguu.core.base

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class BaseListAdapter<D>(
    diffItemCallBack: BaseDiffCallBack<D>
) : ListAdapter<D, RecyclerView.ViewHolder>(diffItemCallBack) {
    abstract fun setView(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    abstract fun bindView(holder: RecyclerView.ViewHolder, position: Int)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return setView(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        bindView(holder, position)
    }

    abstract class BaseDiffCallBack<D> : DiffUtil.ItemCallback<D>()
}
