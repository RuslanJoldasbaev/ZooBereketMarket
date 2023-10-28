package com.example.zoobereketmarket.di

import com.example.zoobereketmarket.data.local.LocalStorage
import okhttp3.Interceptor
import okhttp3.Response

class ZooBereketMarketInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer ${LocalStorage().token}").build()
        return chain.proceed(request)
    }
}