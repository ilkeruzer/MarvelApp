package com.ilkeruzer.marvel.di

import com.ilkeruzer.marvel.remote.ApiService
import com.ilkeruzer.marvel.remote.ApiServiceChief
import com.ilkeruzer.marvel.remote.IApiService
import org.koin.dsl.module

/**
 * Created by İlker Üzer on 8.05.2020.
 */

val appModule = module {


}

val networkModule = module {
    single { ApiService(ApiServiceChief.getRetrofit()!!.create(IApiService::class.java)) }
}


val viewModelModule = module {

}