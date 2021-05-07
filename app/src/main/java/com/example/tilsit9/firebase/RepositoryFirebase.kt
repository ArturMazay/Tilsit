package com.example.tilsit9.firebase

import com.example.tilsit9.domain.Model
import com.example.tilsit9.presentation.Status
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class RepositoryFirebase : ILoadFirebaseData {
    override suspend fun loadDataFb(): Status<List<Model>> {
        var mImage: String
        var mTitle: String
        var mDescription: String
        val modelList = mutableListOf<Model>()
        val listResultFb = FirebaseFirestore.getInstance().collection("Tilsit").get().await()
        for (document in listResultFb) {
            mImage = document.getString("image") ?: ""
            mTitle = document.getString("title") ?: ""
            mDescription = document.getString("description") ?: ""
            modelList.add(Model(mTitle, mDescription, mImage))
        }
        return Status.Success(modelList)
    }
}