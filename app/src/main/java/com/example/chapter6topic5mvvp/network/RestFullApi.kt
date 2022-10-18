package com.example.chapter6topic5mvvp.network

import com.example.chapter6topic5mvvp.model.ResponseCarItem
import retrofit2.Call
import retrofit2.http.GET

interface RestFullApi {
    @GET("admin/car")
    fun getAllCar() : Call<List<ResponseCarItem>>
}