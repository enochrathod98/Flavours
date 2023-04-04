package com.example.flavorsdemo.feature.userlist.domain.repository

import com.example.flavorsdemo.comman.Resource
import com.example.flavorsdemo.feature.userlist.domain.entity.UserEntity

interface UserRepository {
    suspend fun getUsers(): Resource<List<UserEntity>>
}