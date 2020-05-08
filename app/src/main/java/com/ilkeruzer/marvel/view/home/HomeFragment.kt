package com.ilkeruzer.marvel.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ilkeruzer.marvel.base.BaseFragment
import com.ilkeruzer.marvel.databinding.FragmentHomeBinding
import org.koin.android.ext.android.inject


class HomeFragment : BaseFragment<HomeViewModel>() {

    private val vM by inject<HomeViewModel>()
    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCharacters()
        binding.textView.text = "Test Test"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = vM
        super.onCreate(savedInstanceState)
    }

    override fun getViewBindingRoot(inflater: LayoutInflater,container: ViewGroup?): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun getViewModel(): Class<HomeViewModel> {
       return HomeViewModel::class.java
    }


}
