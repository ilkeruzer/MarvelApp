package com.ilkeruzer.marvel.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ilkeruzer.marvel.base.BaseFragment
import com.ilkeruzer.marvel.base.IBaseListener
import com.ilkeruzer.marvel.custom.EndlessRecyclerOnScrollListener
import com.ilkeruzer.marvel.databinding.FragmentHomeBinding
import com.ilkeruzer.marvel.model.Characters
import com.ilkeruzer.marvel.view.adapter.HomeAdapter
import org.koin.android.ext.android.inject


class HomeFragment : BaseFragment<HomeViewModel>(), IBaseListener.Adapter<Characters>  {

    private val vM by inject<HomeViewModel>()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter
    var page = 1

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeRecList.setRecyclerView(true)
        binding.homeRecList.setGridColumn(3)
        viewModel.getCharacters(0)
        setAdapter()
        onScroll()

        viewModel.getCharactersLiveData().observe(viewLifecycleOwner, Observer {
            homeAdapter.getList().addAll(it!!)
            homeAdapter.notifyDataSetChanged()
            binding.progress.visibility = View.GONE
        })

    }

    private fun onScroll() {
        val layoutManager = binding.homeRecList.layoutManager
        binding.homeRecList.addOnScrollListener(object : EndlessRecyclerOnScrollListener(
            layoutManager as LinearLayoutManager?
        ) {

            override fun onLoadMore(page: Int) {
                println("page" + page)
                addLoadMoreData() //yeni değerleri yükle
            }

        })
    }

    private fun addLoadMoreData() {
        binding.progress.visibility = View.VISIBLE
        viewModel.getCharacters((page++)*30)
    }

    private fun setAdapter() {
        val list = ArrayList<Characters>()
        homeAdapter = HomeAdapter(list,this)
        binding.homeRecList.adapter = homeAdapter
    }





    override fun onItemClick(item: Characters, position: Int) {
        TODO("Not yet implemented")
    }


}
