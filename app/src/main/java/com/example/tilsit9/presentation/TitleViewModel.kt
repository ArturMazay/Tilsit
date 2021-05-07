package com.example.tilsit9.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.tilsit9.domain.IGetData
import kotlinx.coroutines.Dispatchers

class TitleViewModel(private val useCase: IGetData) : ViewModel() {

    val loadDataList = liveData(Dispatchers.IO) {
        try {
            val modelList = useCase.getData()
            emit(modelList)

        } catch (e: Exception) {
            //emit(Status.Failure(e.cause))
        }

    }

}

class TitleVMFactory(private val useCase: IGetData) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(IGetData::class.java).newInstance(useCase)
    }
}


