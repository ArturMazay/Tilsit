package com.example.tilsit9

import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyViewHolder(itemView: View, private val onClickTitleCard: OnClickTitleCard) : RecyclerView.ViewHolder(itemView) {

    private val imageTitle: ImageView = itemView.findViewById(R.id.imageView_title)
    /*private val imageName: TextView = itemView.findViewById(R.id.tv_image_name)
    private val imageDescription: TextView = itemView.findViewById(R.id.image_description)
*/
    fun bind(model: Model) {

        Glide.with(imageTitle.context).load(model.image).into(imageTitle)
        imageTitle.setImageResource(R.drawable.tilsit)

        imageTitle.setOnClickListener {
            onClickTitleCard.onClick(model)
            Toast.makeText(itemView.context,"Работает Клик",Toast.LENGTH_LONG).show()
        }

       /* imageName.text = model.title
        imageDescription.text = model.description*/
    }

}
