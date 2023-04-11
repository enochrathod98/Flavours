package com.example.flavorsdemo.feature.multipleview.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.flavorsdemo.databinding.ItemCarouselBinding
import com.example.flavorsdemo.databinding.ItemImageBinding
import com.example.flavorsdemo.databinding.ItemTextBinding
import com.example.flavorsdemo.feature.multipleview.domain.entity.MultipleViewEntity

sealed class MultipleViewVH(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    class TitleViewHolder(private val binding: ItemTextBinding) : MultipleViewVH(binding) {
        fun bind(name: MultipleViewEntity.TextData) {
            binding.textTitleTv.text = name.text
        }
    }

    class ImageViewHolder(private val binding: ItemImageBinding) : MultipleViewVH(binding) {
        fun bind(image: MultipleViewEntity.ImageData) {
            binding.imageTitleTv.text = image.text
            Glide
                .with(binding.root)
                .load(image.url)
                .centerCrop()
                .into(binding.titleImageTmv);
        }
    }

    class CarouselViewHolder(private val binding: ItemCarouselBinding) : MultipleViewVH(binding) {
        fun bind(item: MultipleViewEntity.CarouselData) {
            val adapter = CarouselAdapter()
            binding.carouselRv.adapter = adapter
            adapter.itemList = item.item
        }
    }
}