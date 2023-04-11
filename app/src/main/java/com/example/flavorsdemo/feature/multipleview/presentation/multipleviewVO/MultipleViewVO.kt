package com.example.flavorsdemo.feature.multipleview.presentation.multipleviewVO

import com.example.flavorsdemo.feature.multipleview.domain.entity.MultipleViewEntity

sealed class MultipleViewVO {
    data class Error(val message: String) : MultipleViewVO()
    object Progress : MultipleViewVO()
    data class Loaded(val users: List<MultipleViewEntity>) : MultipleViewVO()
}
