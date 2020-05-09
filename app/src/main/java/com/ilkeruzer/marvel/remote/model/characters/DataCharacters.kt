package com.ilkeruzer.marvel.remote.model.characters

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.ilkeruzer.marvel.model.Characters

/**
 * Created by İlker Üzer on 8.05.2020.
 */

data class DataCharacters(
    @SerializedName("offset")
    @Expose
    val offset: Int? = null,

    @SerializedName("limit")
    @Expose
    val limit: Int? = null,

    @SerializedName("total")
    @Expose
    val total: Int? = null,

    @SerializedName("count")
    @Expose
    val count: Int? = null,

    @SerializedName("results")
    @Expose
    val characterList: List<Characters>? = null
)