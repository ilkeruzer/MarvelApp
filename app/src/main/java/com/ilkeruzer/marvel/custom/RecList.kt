package com.ilkeruzer.marvel.custom

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by İlker Üzer on 8.05.2020.
 */
class RecList @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    fun setRecyclerView(isVertical: Boolean) {
        layoutManager = if (isVertical) {
            LinearLayoutManager(context)
        } else {
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        }
        hasFixedSize()
    }


    fun setGridColumn(gridSize: Int) {
        GridLayoutManager(
            context, gridSize,
            VERTICAL, false
        ).apply {
            layoutManager = this
        }
        hasFixedSize()
    }
}