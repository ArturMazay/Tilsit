package com.example.tilsit9

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

class TitleViewModel : ViewModel() {


    private val firebaseFirestone: FirebaseFirestore = FirebaseFirestore.getInstance()
    val model: MutableLiveData<MutableList<Model>> = MutableLiveData()
    val modelLiveData: LiveData<MutableList<Model>>
        get() = model

    init {
        FirebaseFirestore.getInstance().collection("Tilsit").get()
            .addOnSuccessListener { result ->
                val listData = mutableListOf<Model>()
                for (document in result) {
                    val mImage: String = document.getString("image") ?: ""

                    val mTitle: String = document.getString("title") ?: ""
                    val mDescription: String = document.getString("description") ?: ""
                    val mVideo: String = document.getString("video") ?: ""
                    Log.e("XXX",mVideo)
                    val model = Model(
                        mTitle,
                        mDescription,
                        mImage,
                    )
                    listData.add(model)
                }
                model.value = listData
            }
    }
}
