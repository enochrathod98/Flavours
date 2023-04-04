package com.example.flavorsdemo.feature.userlist.presentation.userVO

import com.example.flavorsdemo.feature.userlist.domain.entity.UserEntity

sealed class UserVo {
    data class Error(val message: String) : UserVo()
    object Progress : UserVo()
    data class Loaded(val users: List<UserEntity>) : UserVo()
}
