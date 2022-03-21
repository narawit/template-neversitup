package com.kaguu.core.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecycleViewAdapter<D> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val _data: MutableList<D> = mutableListOf()
    val data: List<D> = _data

    fun addAll(list: Collection<D>) {
        _data.addAll(list)
        notifyDataSetChanged()
    }

    fun clear() {
        _data.clear()
        notifyDataSetChanged()
    }

    fun add(data: D, index: Int? = null) {
        index?.let {
            _data.add(index, data)
        } ?: run {
            _data.add(data)
        }
        notifyDataSetChanged()
    }

    fun removeAt(index: Int) {
        _data.removeAt(index)
        notifyDataSetChanged()
    }

    fun remove(data: D) {
        _data.remove(data)
        notifyDataSetChanged()
    }

    fun update(data: D, index: Int) {
        _data[index] = data
        notifyItemChanged(index)
    }

    abstract fun setView(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    abstract fun bindView(holder: RecyclerView.ViewHolder, position: Int)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return setView(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        bindView(holder, position)
    }

    override fun getItemCount(): Int = data.size
}