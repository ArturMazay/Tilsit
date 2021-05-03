package com.example.tilsit9.firebase

import com.example.tilsit9.domain.Model
import com.example.tilsit9.presentation.Status
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class RepositoryFirebase : ILoadFirebaseData {
    override suspend fun loadDataFb(): Status<MutableList<Model>> {
        val modelList = mutableListOf<Model>()
        val listResultFb = FirebaseFirestore.getInstance().collection("Tilsit").get().await()
        for(document in listResultFb){
            val mImage: String = document.getString("image") ?: ""
            val mTitle: String = document.getString("title") ?: ""
            val mDescription: String = document.getString("description") ?: ""
            modelList.add(Model(mTitle, mDescription, mImage))
        }
        return Status.Success(modelList)
    }
}