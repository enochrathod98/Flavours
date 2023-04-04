package com.example.flavorsdemo.feature.userlist.domain.usecase

import com.example.flavorsdemo.comman.Resource
import com.example.flavorsdemo.feature.userlist.domain.entity.UserEntity
import com.example.flavorsdemo.feature.userlist.domain.repository.UserRepository
import javax.inject.Inject

class UserUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(): Resource<List<UserEntity>> {
        return userRepository.getUsers()
    }
}