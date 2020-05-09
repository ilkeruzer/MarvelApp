package com.ilkeruzer.marvel.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ilkeruzer.marvel.base.BaseRecyclerAdapter
import com.ilkeruzer.marvel.base.IBaseListener
import com.ilkeruzer.marvel.databinding.ItemHomeLayoutBinding
import com.ilkeruzer.marvel.model.Characters
import com.ilkeruzer.marvel.util.ImageLoader

/**
 * Created by İlker Üzer on 8.05.2020.
 */
class HomeAdapter (
    private val list: ArrayList<Characters>,
    private val listener: IBaseListener.Adapter<Characters>
) : BaseRecyclerAdapter<Characters>(list) {

    private lateinit var binding: ItemHomeLayoutBinding

    override fun onBindBaseViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val vH: HomeHolder = holder as HomeHolder
        vH.bind(list[position],listener)
    }

    override fun onCreateBaseViewHolder(v: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemHomeLayoutBinding.inflate(LayoutInflater.from(v!!.context),v,false)
        return HomeHolder(binding)
    }

    class HomeHolder (binding: ItemHomeLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        private var imageView = binding.imageView
        private var textView = binding.nameText

        fun bind(
            characters: Characters,
            listener: IBaseListener.Adapter<Characters>
        ) {
            val imageURL = "${characters.thumbnail?.path}.${characters.thumbnail?.extension}"
            ImageLoader.normalImage(imageView,imageURL)
            textView.text = characters.name

            itemView.setOnClickListener { listener.onItemClick(characters,adapterPosition) }
        }

    }

    fun getList(): ArrayList<Characters> {
        return list
    }
}