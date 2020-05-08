package com.ilkeruzer.marvel.view.home

import com.ilkeruzer.marvel.base.BaseViewModel
import com.ilkeruzer.marvel.model.Post
import com.ilkeruzer.marvel.remote.ApiService
import com.ilkeruzer.marvel.remote.IResponseStatus

/**
 * Created by İlker Üzer on 8.05.2020.
 */

class HomeViewModel (private val apiService: ApiService): BaseViewModel() {


     fun postsAPI() {
        apiService.getNewsInfo()
            .apiResponse(object : IResponseStatus<List<Post>> {
                override fun onSuccess(t: List<Post>) {
                    println("onSuccess")
                    t.forEach { print(it.toString()) }
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