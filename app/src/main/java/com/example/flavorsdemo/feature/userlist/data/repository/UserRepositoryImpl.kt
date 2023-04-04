package com.example.flavorsdemo.feature.userlist.data.repository

import com.example.flavorsdemo.comman.Resource
import com.example.flavorsdemo.feature.userlist.data.model.toEntity
import com.example.flavorsdemo.feature.userlist.data.source.UserSource
import com.example.flavorsdemo.feature.userlist.domain.entity.UserEntity
import com.example.flavorsdemo.feature.userlist.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userSource: UserSource) : UserRepository {
    override suspend fun getUsers(): Resource<List<UserEntity>> {
        val model = userSource.getUsers()
        val list = model.users.map {
            it.toEntity()
        }
        return Resource.Success(list)
    }
}