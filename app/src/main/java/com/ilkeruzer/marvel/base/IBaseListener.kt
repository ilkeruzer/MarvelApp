package com.ilkeruzer.marvel.base

class IBaseListener {

    interface Adapter<T> {
        fun onItemClick(item: T, position: Int)
    }
}
