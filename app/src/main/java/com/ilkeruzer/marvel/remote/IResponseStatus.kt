package com.ilkeruzer.marvel.remote

/**
 * Created by İlker Üzer on 8.05.2020.
 */

interface IResponseStatus<T> {
    fun onSuccess(t: T)
    fun onUnauthorized()
    fun onError()
    fun onFailed()
}