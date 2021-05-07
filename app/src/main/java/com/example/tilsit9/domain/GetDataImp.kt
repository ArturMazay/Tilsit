package com.example.tilsit9.domain


import com.example.tilsit9.firebase.ILoadFirebaseData
import com.example.tilsit9.presentation.Status

class GetDataImp (private val repositoryFirebase: ILoadFirebaseData):IGetData  {
    override suspend fun getData(): Status<List<Model>> = repositoryFirebase.loadDataFb()

}