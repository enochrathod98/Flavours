package com.example.flavorsdemo.feature.multipleview.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flavorsdemo.databinding.CarouselDetailViewBinding

class CarouselVH(private val binding: CarouselDetailViewBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(itemsItem: com.example.flavorsdemo.feature.multipleview.data.model.ItemData) {
        binding.carouselTitleTv.text = itemsItem.id
        Glide
            .with(binding.root)
            .load(itemsItem.image)
            .centerCrop()
            .into(binding.carouselTmv);
    }
}