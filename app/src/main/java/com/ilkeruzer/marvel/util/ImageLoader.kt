package com.ilkeruzer.marvel.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.ilkeruzer.marvel.R

/**
 * Created by İlker Üzer on 8.05.2020.
 */
object ImageLoader {

    fun normalImage(imageView: ImageView, url: String) {
        Glide.with(imageView)
            .load(url)
            .fitCenter()
            .placeholder(R.drawable.ic_launcher_background)
            .into(imageView)
    }
}