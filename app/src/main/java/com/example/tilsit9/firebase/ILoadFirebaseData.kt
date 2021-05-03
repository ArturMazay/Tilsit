package com.example.tilsit9.firebase

import com.example.tilsit9.domain.Model
import com.example.tilsit9.presentation.Status

interface ILoadFirebaseData {
    suspend fun loadDataFb() : Status<MutableList<Model>>
}
