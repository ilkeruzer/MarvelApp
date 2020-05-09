package com.ilkeruzer.marvel.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ilkeruzer.marvel.base.BaseRecyclerAdapter
import com.ilkeruzer.marvel.base.IBaseListener
import com.ilkeruzer.marvel.databinding.ItemComicLayoutBinding
import com.ilkeruzer.marvel.model.Comics

/**
 * Created by İlker Üzer on 8.05.2020.
 */
class ComicsAdapter(
    private val list: ArrayList<Comics>,
    private val listener: IBaseListener.Adapter<Comics>
) : BaseRecyclerAdapter<Comics>(list) {

    private lateinit var binding: ItemComicLayoutBinding

    override fun onBindBaseViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val vH: ComicsHolder = holder as ComicsHolder
        vH.bind(list[position],listener)
    }

    override fun onCreateBaseViewHolder(v: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemComicLayoutBinding.inflate(LayoutInflater.from(v!!.context),v,false)
        return ComicsHolder(binding)
    }

    class ComicsHolder (binding: ItemComicLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        private var titleTxt = binding.titleText
        private var descTxt = binding.descText


        fun bind(
            comics: Comics,
            listener: IBaseListener.Adapter<Comics>
        ) {
            descTxt.text = comics.description
            titleTxt.text = comics.title

            itemView.setOnClickListener { listener.onItemClick(comics,adapterPosition) }
        }

    }

    fun getList(): ArrayList<Comics> {
        return list
    }
}