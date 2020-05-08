package com.ilkeruzer.marvel.remote

import com.ilkeruzer.marvel.model.Post

/**
 * Created by İlker Üzer on 8.05.2020.
 */
class ApiService(var iApiService: IApiService) {

    fun getNewsInfo(): ApiServiceGateway<List<Post>> {
        return ApiServiceGateway(iApiService.getPosts())
    }


}
