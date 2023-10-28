package com.example.zoobereketmarket.domain

import com.example.zoobereketmarket.data.models.ResultData
import com.example.zoobereketmarket.data.remote.ZooBereketMarketApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class AnimalsRepository(val api: ZooBereketMarketApi) {

    suspend fun getCategories() = flow {

        val response = api.getCategories()

        if (response.isSuccessful) {
            emit(ResultData.Success(response.body()!!))
        } else {
            emit(ResultData.Message(response.message()))
        }
    }.catch {
        emit(ResultData.Error(it))
    }
}