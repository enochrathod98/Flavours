package com.example.flavorsdemo.feature.applicationtype.data.source

import com.example.flavorsdemo.feature.applicationtype.data.model.ApplicationTypeResponse
import retrofit2.http.GET

interface ApplicationTypeSource  {
    @GET("/test")
    suspend fun getApplicationType() : ApplicationTypeResponse
}