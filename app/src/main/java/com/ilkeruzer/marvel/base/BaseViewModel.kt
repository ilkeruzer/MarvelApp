package com.ilkeruzer.marvel.base

import androidx.lifecycle.*
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by İlker Üzer on 8.05.2020.
 */

open class BaseViewModel : ViewModel(), LifecycleObserver,IBase {

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun unSubscribeViewModel() {
        compositeDisposable.dispose()
    }

}