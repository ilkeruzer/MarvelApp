package com.ilkeruzer.marvel.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by İlker Üzer on 8.05.2020.
 */
data class Thumbnail(
    @SerializedName("path")
    @Expose
    val path: String? = null,

    @SerializedName("extension")
    @Expose
    val extension: String? = null

)