package com.ilkeruzer.marvel.view.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ilkeruzer.marvel.base.BaseViewModel
import com.ilkeruzer.marvel.base.IBase
import com.ilkeruzer.marvel.model.Characters
import com.ilkeruzer.marvel.model.Comics
import com.ilkeruzer.marvel.remote.ApiService
import com.ilkeruzer.marvel.remote.IResponseStatus
import com.ilkeruzer.marvel.remote.model.characters.WrapperCharacters
import com.ilkeruzer.marvel.remote.model.comics.WrapperComics

/**
 * Created by İlker Üzer on 9.05.2020.
 */
class DetailViewModel(private val service: ApiService) : BaseViewModel() {

    private val charactersLiveData = MutableLiveData<List<Comics>>()


    fun getComics(characterId: Int) {
        service.getComics(
            characterId,
            "2005-01-01,2020-01-02")
            .apiResponse(object : IResponseStatus<WrapperComics> {
                override fun onSuccess(t: WrapperComics) {
                    println("onSuccess getComics")
                    if (t.code == IBase.SUCCESS && t.status.equals(IBase.STATUS)) {
                        t.dataComics?.characterList.let { charactersLiveData.value = it }
                    }
                }

                override fun onUnauthorized() {
                    println("onUnauthorized getComics")
                }

                override fun onError() {
                    println("onError getComics")
                }

                override fun onFailed() {
                    println("onFailed getComics")
                }

            })
    }

    fun getComicsLiveData(): LiveData<List<Comics>> {
        return charactersLiveData
    }

}
