package com.ilkeruzer.marvel.util

import com.himanshurawat.hasher.HashType
import com.himanshurawat.hasher.Hasher
import com.ilkeruzer.marvel.BuildConfig

/**
 * Created by İlker Üzer on 8.05.2020.
 */
object KeyUtil {
    val ts = System.currentTimeMillis()

     fun getApiKey() : String {
        return Hasher.hash(ts.toString() +
                BuildConfig.PRIVATE_KEY +
                BuildConfig.PUBLIC_KEY,
            HashType.MD5)
    }
}