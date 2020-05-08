package com.ilkeruzer.marvel.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by İlker Üzer on 8.05.2020.
 */

data class Post(
    @SerializedName("id")
    @Expose
    var status: Int? = null,

    @SerializedName("body")
    @Expose
    var articles: String? = null
) : Serializable