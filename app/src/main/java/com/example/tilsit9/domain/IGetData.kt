package com.example.tilsit9.domain

import com.example.tilsit9.presentation.Status

interface IGetData {
    suspend fun getData():Status<MutableList<Model>>
}