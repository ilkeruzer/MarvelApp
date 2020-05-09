package com.ilkeruzer.marvel.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.ilkeruzer.marvel.base.BaseFragment
import com.ilkeruzer.marvel.databinding.FragmentDetailBinding
import com.ilkeruzer.marvel.util.ImageLoader
import org.koin.android.ext.android.inject

/**
 * Created by İlker Üzer on 9.05.2020.
 */
class DetailFragment : BaseFragment<DetailViewModel>() {

    private val vM by inject<DetailViewModel>()
    private lateinit var binding: FragmentDetailBinding

    private val ARG_PARAM1 = "id"
    private val ARG_PARAM2 = "name"
    private val ARG_PARAM3 = "image"

    private var id: Int? = null
    private var name: String? = null
    private var image: String? = null


    override fun getViewBindingRoot(inflater: LayoutInflater, container: ViewGroup?): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun getViewModel(): Class<DetailViewModel> {
        return DetailViewModel::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = vM
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            id = requireArguments().getInt(ARG_PARAM1)
            name = requireArguments().getString(ARG_PARAM2)
            image = requireArguments().getString(ARG_PARAM3)
            println("id : $id")
            println("name : $name")
            println("image : $image")

            image?.let { ImageLoader.normalImage(binding.imageView, it) }
            name?.let { binding.nameText.text = it }
        }

        id?.let { viewModel.getComics(it) }

        viewModel.getComicsLiveData().observe(viewLifecycleOwner, Observer {
            it.forEach { it1 -> println("id: ${it1.id}") }
        })
    }

}