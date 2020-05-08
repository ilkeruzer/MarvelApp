package com.ilkeruzer.marvel.view.home

import com.ilkeruzer.marvel.base.BaseViewModel
import com.ilkeruzer.marvel.model.Post
import com.ilkeruzer.marvel.remote.ApiService
import com.ilkeruzer.marvel.remote.IResponseStatus
import com.ilkeruzer.marvel.remote.model.Wrapper

/**
 * Created by İlker Üzer on 8.05.2020.
 */

class HomeViewModel (private val apiService: ApiService): BaseViewModel() {

    fun getCharacters() {
        apiService.getCharacters()
            .apiResponse(object : IResponseStatus<Wrapper> {
                override fun onSuccess(t: Wrapper) {
                    println(t)
                    println("onSuccess")
                }

                override fun onUnauthorized() {
                    println("onUnauthorized")
                }

                override fun onError() {
                    println("onError")
                }

                override fun onFailed() {
                    println("onFailed")
                }

            })
    }
}