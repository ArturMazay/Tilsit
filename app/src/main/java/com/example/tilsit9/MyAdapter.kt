package com.example.tilsit9

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class MyAdapter(private val onClickTitleCard: OnClickTitleCard) : ListAdapter<Model, MyViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_title, parent, false),onClickTitleCard
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model)
      /*  holder.itemView.setOnClickListener {
            onClickListenerToMovieDetails?.onClickOpenDetailsMovieFragment(movie)
        }*/
    }
}

class DiffCallback : DiffUtil.ItemCallback<Model>() {
    override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
        return oldItem.image == newItem.image
    }

    override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
        return oldItem == newItem
    }
}
