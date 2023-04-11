package com.example.flavorsdemo.feature.multipleview.data.source

import com.example.flavorsdemo.feature.multipleview.data.model.DataResponse
import retrofit2.http.GET

interface MultipleViewSource {
    @GET("/multipleview")
    suspend fun getData() : DataResponse
}