package com.ilkeruzer.marvel.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by İlker Üzer on 10.05.2020.
 */
object DateUtil {

    fun getDateDiff(): String {
        val currentDate: String = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        return "2005-01-01,$currentDate"
    }
}