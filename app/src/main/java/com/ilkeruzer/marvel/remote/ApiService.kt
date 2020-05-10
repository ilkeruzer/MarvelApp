package com.ilkeruzer.marvel.remote

import com.ilkeruzer.marvel.BuildConfig
import com.ilkeruzer.marvel.remote.model.characters.WrapperCharacters
import com.ilkeruzer.marvel.remote.model.comics.WrapperComics
import com.ilkeruzer.marvel.util.KeyUtil

/**
 * Created by İlker Üzer on 8.05.2020.
 */
class ApiService(var iApiService: IApiService) {

    fun getCharacters(page: Int,offset: Int): ApiServiceGateway<WrapperCharacters> {
        return ApiServiceGateway(iApiService.getCharactersEP(KeyUtil.ts.toString(),
            BuildConfig.PUBLIC_KEY,
            KeyUtil.getApiKey(),
            page,
            offset
            )
        )
    }

    fun getComics(characterId: Int,range: String): ApiServiceGateway<WrapperComics> {
        return ApiServiceGateway(iApiService.getComicsEP(
            characterId,
            KeyUtil.ts.toString(),
            BuildConfig.PUBLIC_KEY,
            KeyUtil.getApiKey(),
            10,
            range
        ))
    }




}
