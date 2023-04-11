package com.example.flavorsdemo.feature.multipleview.data.model

import com.google.gson.annotations.SerializedName

data class DataResponse(

    @field:SerializedName("data")
    val data: List<DataItem?>? = null
)

data class ItemData(

    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("id")
    val id: String? = null
)

data class DataItem(

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("items")
    val items: List<ItemData>,

    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("text")
    val text: String? = null
)
