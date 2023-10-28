package com.example.zoobereketmarket.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zoobereketmarket.data.models.ResultData
import com.example.zoobereketmarket.data.models.categories.CategoriesResponseData
import com.example.zoobereketmarket.domain.AnimalsRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class AnimalsViewModel(private val repo: AnimalsRepository) : ViewModel() {

    val getCategoriesFlow = MutableSharedFlow<CategoriesResponseData>()
    val messageFlow = MutableSharedFlow<String>()
    val errorFlow = MutableSharedFlow<Throwable>()

    suspend fun getCategories() {
        repo.getCategories().onEach {
            when (it) {
                is ResultData.Success -> {
                    getCategoriesFlow.emit(it.data)
                }
                is ResultData.Message -> {
                    messageFlow.emit(it.message)
                }
                is ResultData.Error -> {
                    errorFlow.emit(it.error)
                }
            }
        }.launchIn(viewModelScope)
    }
}