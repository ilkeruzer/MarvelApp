package com.ilkeruzer.marvel.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by İlker Üzer on 8.05.2020.
 */

data class Characters (
    @SerializedName("id")
    @Expose
    val id: Long? = null,

    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("thumbnail")
    @Expose
    val thumbnail: Thumbnail? = null
)