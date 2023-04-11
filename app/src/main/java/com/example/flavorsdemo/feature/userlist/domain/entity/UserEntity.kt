package com.example.flavorsdemo.feature.userlist.domain.entity

import com.example.flavorsdemo.feature.userlist.data.model.Status

data class UserEntity(val name: String, val state: Status, val date: String)