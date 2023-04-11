package com.example.flavorsdemo.feature.multipleview.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flavorsdemo.R
import com.example.flavorsdemo.databinding.ItemCarouselBinding
import com.example.flavorsdemo.databinding.ItemImageBinding
import com.example.flavorsdemo.databinding.ItemTextBinding
import com.example.flavorsdemo.feature.multipleview.domain.entity.MultipleViewEntity

class MultipleViewAdapter : RecyclerView.Adapter<MultipleViewVH>() {

    var items = listOf<MultipleViewEntity>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultipleViewVH {
        return when (viewType) {
            R.layout.item_text -> MultipleViewVH.TitleViewHolder(
                ItemTextBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            R.layout.item_image -> MultipleViewVH.ImageViewHolder(
                ItemImageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            R.layout.item_carousel -> MultipleViewVH.CarouselViewHolder(
                ItemCarouselBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is MultipleViewEntity.TextData -> R.layout.item_text
            is MultipleViewEntity.ImageData -> R.layout.item_image
            is MultipleViewEntity.CarouselData -> R.layout.item_carousel
        }
    }

    override fun onBindViewHolder(holder: MultipleViewVH, position: Int) {
        val data = items[position]
        when (holder) {
            is MultipleViewVH.TitleViewHolder -> holder.bind(data as MultipleViewEntity.TextData)
            is MultipleViewVH.ImageViewHolder -> holder.bind(data as MultipleViewEntity.ImageData)
            is MultipleViewVH.CarouselViewHolder -> holder.bind(data as MultipleViewEntity.CarouselData)
        }
    }

    override fun getItemCount() = items.size
}
