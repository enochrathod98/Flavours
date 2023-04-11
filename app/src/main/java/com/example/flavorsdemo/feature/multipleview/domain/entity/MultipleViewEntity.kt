package com.example.flavorsdemo.feature.multipleview.domain.entity

import com.example.flavorsdemo.feature.multipleview.data.model.ItemData

sealed class MultipleViewEntity {
    data class TextData(
        val type: String,
        val text: String
    ) : MultipleViewEntity()

    data class ImageData(
        val type: String,
        val text: String,
        val url: String
    ) : MultipleViewEntity()

    data class CarouselData(
        val type: String,
        val text: String,
        val item: List<ItemData>
    ) : MultipleViewEntity()
}

data class ItemData(
    val id: String,
    val image: String
)
