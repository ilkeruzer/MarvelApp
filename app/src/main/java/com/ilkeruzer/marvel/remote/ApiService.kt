package com.ilkeruzer.marvel.remote

import com.ilkeruzer.marvel.BuildConfig
import com.ilkeruzer.marvel.remote.model.Wrapper
import com.ilkeruzer.marvel.util.KeyUtil

/**
 * Created by İlker Üzer on 8.05.2020.
 */
class ApiService(var iApiService: IApiService) {


    fun getCharacters(): ApiServiceGateway<Wrapper> {
        return ApiServiceGateway(iApiService.getCharactersEP(KeyUtil.ts.toString(),
            BuildConfig.PUBLIC_KEY,
            KeyUtil.getApiKey()
            )
        )
    }


}
