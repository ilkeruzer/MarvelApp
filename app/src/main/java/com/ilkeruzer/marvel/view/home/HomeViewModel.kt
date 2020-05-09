package com.ilkeruzer.marvel.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ilkeruzer.marvel.base.BaseViewModel
import com.ilkeruzer.marvel.base.IBase.Companion.STATUS
import com.ilkeruzer.marvel.base.IBase.Companion.SUCCESS
import com.ilkeruzer.marvel.model.Characters
import com.ilkeruzer.marvel.remote.ApiService
import com.ilkeruzer.marvel.remote.IResponseStatus
import com.ilkeruzer.marvel.remote.model.Wrapper

/**
 * Created by İlker Üzer on 8.05.2020.
 */

class HomeViewModel (private val apiService: ApiService): BaseViewModel() {

    private val charactersLiveData = MutableLiveData<List<Characters>>()

    fun getCharacters(offset: Int) {
        apiService.getCharacters(30,offset)
            .apiResponse(object : IResponseStatus<Wrapper> {
                override fun onSuccess(t: Wrapper) {
                    println("onSuccess")
                    if (t.code == SUCCESS && t.status.equals(STATUS)) {
                        t.data?.characterList.let { charactersLiveData.value = it }
                    }
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

    fun getCharactersLiveData() : LiveData<List<Characters>> {
        return charactersLiveData
    }
}