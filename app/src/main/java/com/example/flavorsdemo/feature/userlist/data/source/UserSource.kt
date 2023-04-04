package com.example.flavorsdemo.feature.userlist.data.source

import com.example.flavorsdemo.feature.userlist.data.model.UserResponse
import retrofit2.http.GET

interface UserSource {
    @GET("/testing")
    suspend fun getUsers() : UserResponse
}