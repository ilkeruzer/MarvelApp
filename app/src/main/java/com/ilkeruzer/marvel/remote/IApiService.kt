package com.ilkeruzer.marvel.remote

import com.ilkeruzer.marvel.model.Post
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by İlker Üzer on 8.05.2020.
 */

interface IApiService {

    @GET("posts")
    fun getPosts(): Observable<Response<List<Post>>>
}