package com.example.flavorsdemo.feature.multipleview.data.model

import com.example.flavorsdemo.feature.multipleview.domain.entity.MultipleViewEntity

fun DataItem.toEntity(): MultipleViewEntity {
    return when (type) {
        "text" -> MultipleViewEntity.TextData(type.toString(), text.toString())
        "image" -> MultipleViewEntity.ImageData(
            type.toString(),
            text.toString(),
            image.toString()
        )
        "carousel" -> MultipleViewEntity.CarouselData(
            type.toString(),
            text.toString(),
            items
        )
        else -> {
            throw IllegalStateException("Unknown view")
        }
    }
}
