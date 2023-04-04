package com.example.flavorsdemo.feature.userlist.data.model

import com.example.flavorsdemo.feature.userlist.domain.entity.UserEntity

fun UsersItem.toEntity(): UserEntity {
    return UserEntity(
        name = name.toString(),
        state = status.toString(),
        date = date.toString()
    )
}

