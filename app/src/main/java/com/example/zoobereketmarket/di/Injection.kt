package com.example.zoobereketmarket.di

import com.example.zoobereketmarket.data.constants.Constants
import com.example.zoobereketmarket.data.remote.ZooBereketMarketApi
import com.example.zoobereketmarket.domain.AnimalsRepository
import com.example.zoobereketmarket.presentation.AnimalsViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single<AnimalsRepository> {
        AnimalsRepository(api = get())
    }

    single<Retrofit> {
        val httpLogginInterceptor = HttpLoggingInterceptor().setLevel(
            HttpLoggingInterceptor.Level.BODY
        )

        val interceptor = ZooBereketMarketInterceptor()

        val client = OkHttpClient.Builder()
            .addInterceptor(httpLogginInterceptor)
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .build()
        retrofit
    }

    single<ZooBereketMarketApi> {
        provideApi(retrofit = get())
    }
}

val viewModelModule = module {
    factory {
        AnimalsViewModel(repo = get())
    }
}

fun provideApi(retrofit: Retrofit): ZooBereketMarketApi {
    return retrofit.create(ZooBereketMarketApi::class.java)
}