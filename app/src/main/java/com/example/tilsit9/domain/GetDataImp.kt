package com.example.tilsit9.domain

import com.example.tilsit9.firebase.RepositoryFirebase
import com.example.tilsit9.presentation.Status

class GetDataImp (private val repositoryFirebase: RepositoryFirebase):IGetData {
    override suspend fun getData(): Status<MutableList<Model>> = repositoryFirebase.loadDataFb()
}