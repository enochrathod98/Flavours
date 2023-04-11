package com.example.flavorsdemo.feature.multipleview.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flavorsdemo.databinding.CarouselDetailViewBinding

class CarouselAdapter : RecyclerView.Adapter<CarouselVH>() {

    var itemList: List<com.example.flavorsdemo.feature.multipleview.data.model.ItemData> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselVH {
        return CarouselVH(
            CarouselDetailViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    }

    override fun onBindViewHolder(holder: CarouselVH, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

}