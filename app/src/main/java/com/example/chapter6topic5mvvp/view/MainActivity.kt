package com.example.chapter6topic5mvvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapter6topic5mvvp.databinding.ActivityMainBinding
import com.example.chapter6topic5mvvp.viewmodel.CarViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val viewModel : CarViewModel by viewModels()
    lateinit var  carAdapter: CarAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getAllDataCars()
        viewModel.GetlvDataCar().observe(this){
            if (it != null){
                binding.apply {
                    rvCar.layoutManager = LinearLayoutManager(this@MainActivity)
                    rvCar.adapter = CarAdapter(it)
                }
            }
        }
    }
}