package com.example.chapter6topic5mvvp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    const val BASE_URL = "https://rent-cars-api.herokuapp.com/"

    val instance : RestFullApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(RestFullApi::class.java)
    }
}