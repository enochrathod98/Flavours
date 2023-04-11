package com.example.flavorsdemo.feature.multipleview.domain.repository

import com.example.flavorsdemo.comman.Resource
import com.example.flavorsdemo.feature.multipleview.domain.entity.MultipleViewEntity

interface MultipleViewRepository {
    suspend fun getData(): Resource<List<MultipleViewEntity>>
}