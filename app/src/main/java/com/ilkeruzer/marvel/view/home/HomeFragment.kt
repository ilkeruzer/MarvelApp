package com.ilkeruzer.marvel.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.ilkeruzer.marvel.base.BaseFragment
import com.ilkeruzer.marvel.base.IBaseListener
import com.ilkeruzer.marvel.databinding.FragmentHomeBinding
import com.ilkeruzer.marvel.model.Characters
import com.ilkeruzer.marvel.view.adapter.HomeAdapter
import org.koin.android.ext.android.inject


class HomeFragment : BaseFragment<HomeViewModel>(), IBaseListener.Adapter<Characters>  {

    private val vM by inject<HomeViewModel>()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeRecList.setRecyclerView(true)
        viewModel.getCharacters()
        setAdapter()


    }

    private fun setAdapter() {
        viewModel.getCharactersLiveData()
            .observe(viewLifecycleOwner, Observer {
                homeAdapter = HomeAdapter(it as MutableList<Characters>, this)
                it.forEach { t: Characters? -> println(t) }
                binding.homeRecList.adapter = homeAdapter
            })
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

    override fun onItemClick(item: Characters, position: Int) {
        TODO("Not yet implemented")
    }


}
