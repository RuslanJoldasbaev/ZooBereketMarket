package com.example.zoobereketmarket.data.remote

import com.example.zoobereketmarket.data.models.categories.CategoriesResponseData
import retrofit2.Response
import retrofit2.http.GET

interface ZooBereketMarketApi {

    @GET("api/categories")
    suspend fun getCategories(): Response<CategoriesResponseData>

}