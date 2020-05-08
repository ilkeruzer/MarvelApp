package com.ilkeruzer.marvel.remote

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ilkeruzer.marvel.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by İlker Üzer on 8.05.2020.
 */

object ApiServiceChief {

    private var retrofit: Retrofit? = null
    private var okHttpClient: OkHttpClient? = null
    private var gson: Gson? = null

    private fun getOkHttpClient(): OkHttpClient? {
        if (okHttpClient == null) {
            okHttpClient = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build()
        }
        return okHttpClient
    }

    private fun getGson(): Gson? {
        if (gson == null) {
            gson = GsonBuilder().setLenient().create()
        }
        return gson
    }

    fun getRetrofit(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.SERVER_URL)
                .client(getOkHttpClient()!!)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}