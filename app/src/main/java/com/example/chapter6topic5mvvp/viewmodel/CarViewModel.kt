package com.example.chapter6topic5mvvp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chapter6topic5mvvp.model.ResponseCarItem
import com.example.chapter6topic5mvvp.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarViewModel : ViewModel() {
    val DataCar : MutableLiveData<List<ResponseCarItem>> = MutableLiveData()
    fun GetlvDataCar() : MutableLiveData<List<ResponseCarItem>> = DataCar

    fun getAllDataCars(){
        RetrofitClient.instance.getAllCar()
            .enqueue(object : Callback<List<ResponseCarItem>>{
                override fun onResponse(
                    call: Call<List<ResponseCarItem>>,
                    response: Response<List<ResponseCarItem>>
                ) {
                    if (response.isSuccessful)
                        DataCar.postValue(response.body())
                    else
                        DataCar.postValue(null)
                }

                override fun onFailure(call: Call<List<ResponseCarItem>>, t: Throwable) {
                    DataCar.postValue(null)
                }
            })
    }
}