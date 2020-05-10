package com.ilkeruzer.marvel.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Created by İlker Üzer on 8.05.2020.
 */

abstract class BaseFragment<VM : BaseViewModel>() : Fragment() {

    protected lateinit var viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return getViewBindingRoot(inflater,container)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.unSubscribeViewModel()
    }

    protected abstract fun getViewBindingRoot(inflater: LayoutInflater,container: ViewGroup?): View?
    protected abstract fun getViewModel(): Class<VM>

}