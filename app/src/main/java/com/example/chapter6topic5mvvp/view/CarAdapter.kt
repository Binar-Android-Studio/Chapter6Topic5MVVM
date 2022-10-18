package com.example.chapter6topic5mvvp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chapter6topic5mvvp.databinding.ItemCarBinding
import com.example.chapter6topic5mvvp.model.ResponseCarItem

class CarAdapter (var listData : List<ResponseCarItem>) : RecyclerView.Adapter<CarAdapter.ViewHolder>(){
    inner class ViewHolder(var binding : ItemCarBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(item : ResponseCarItem) {
                binding.apply {
                    nameCar.text = item.name
                    categoryCar.text = item.category
                    priceCar.text = item.price.toString()

                    Glide.with(itemView)
                        .load(item.image)
                        .into(imgCar)
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}