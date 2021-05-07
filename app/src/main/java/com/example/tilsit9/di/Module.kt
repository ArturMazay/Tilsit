package com.example.tilsit9.di


import com.example.tilsit9.domain.GetDataImp
import com.example.tilsit9.domain.IGetData
import com.example.tilsit9.firebase.ILoadFirebaseData
import com.example.tilsit9.firebase.RepositoryFirebase
import com.example.tilsit9.presentation.TitleViewModel

import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.dsl.module

val domain = module {
    single <IGetData>{GetDataImp(repositoryFirebase = get())}
    viewModel { TitleViewModel(useCase = get()) }
}

val data = module {
    single <ILoadFirebaseData> { RepositoryFirebase() }

}