package com.example.tilsit9.presentation

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.tilsit9.R
import com.example.tilsit9.domain.Model


class MyViewHolder(itemView: View, private val onClickTitleCard: OnClickTitleCard) : RecyclerView.ViewHolder(itemView) {

    private val imageTitle: ImageView = itemView.findViewById(R.id.imageView_title)
    private val tvTitle:TextView=itemView.findViewById(R.id.tv_image_name)

    fun bind(model: Model) {

        imageTitle.load(model.image)
        tvTitle.text = model.title

        imageTitle.setOnClickListener {
            onClickTitleCard.onClick(model)
            Toast.makeText(itemView.context,"Работает Клик",Toast.LENGTH_LONG).show()
        }
    }
}
