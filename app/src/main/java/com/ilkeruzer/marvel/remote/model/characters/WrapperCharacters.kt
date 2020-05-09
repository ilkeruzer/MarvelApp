package com.ilkeruzer.marvel.remote.model.characters

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.ilkeruzer.marvel.remote.model.characters.DataCharacters
import java.io.Serializable

/**
 * Created by İlker Üzer on 8.05.2020.
 */
data class WrapperCharacters(
    @SerializedName("code")
    @Expose
    val code: Int? = null,

    @SerializedName("status")
    @Expose
    val status: String? = null,

    @SerializedName("copyright")
    @Expose
    val copyright: String? = null,

    @SerializedName("data")
    @Expose
    val dataCharacters: DataCharacters? = null
): Serializable