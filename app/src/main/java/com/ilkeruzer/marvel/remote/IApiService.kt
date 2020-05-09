package com.ilkeruzer.marvel.remote

import com.ilkeruzer.marvel.remote.model.characters.WrapperCharacters
import com.ilkeruzer.marvel.remote.model.comics.WrapperComics
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by İlker Üzer on 8.05.2020.
 */

interface IApiService {

    @GET("characters")
    fun getCharactersEP(
        @Query("ts") ts: String?,
        @Query("apikey") apiKey: String?,
        @Query("hash") hash: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ) : Observable<Response<WrapperCharacters>>

    @GET("characters/{characterId}/comics")
    fun getComicsEP(
        @Path("characterId") characterId: Int?,
        @Query("ts") ts: String?,
        @Query("apikey") apiKey: String?,
        @Query("hash") hash: String?,
        @Query("limit") limit: Int?,
        @Query("dateRange") dateRange: String?
    ): Observable<Response<WrapperComics>>

}