package com.example.tilsit9

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter() : RecyclerView.Adapter<MyViewHolder>() {

    var data = mutableListOf<Model>()
        set(value) {
            field = value

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_title, parent, false))


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])

    }

    override fun getItemCount(): Int = data.size
}
