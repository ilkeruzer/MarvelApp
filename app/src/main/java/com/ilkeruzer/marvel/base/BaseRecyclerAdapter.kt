package com.ilkeruzer.marvel.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by İlker Üzer on 8.05.2020.
 */

abstract class BaseRecyclerAdapter<T>(private val list: MutableList<T>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    protected abstract fun onBindBaseViewHolder(
        holder: RecyclerView.ViewHolder?,
        position: Int
    )

    protected abstract fun onCreateBaseViewHolder(
        v: ViewGroup?,
        viewType: Int
    ): RecyclerView.ViewHolder

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return onCreateBaseViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        onBindBaseViewHolder(holder, position)
    }

}