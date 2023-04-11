package com.example.flavorsdemo.feature.multipleview.domain.usecase

import com.example.flavorsdemo.comman.Resource
import com.example.flavorsdemo.feature.multipleview.domain.entity.MultipleViewEntity
import com.example.flavorsdemo.feature.multipleview.domain.repository.MultipleViewRepository
import javax.inject.Inject

class MultipleViewUseCase @Inject constructor(private val multipleViewRepository: MultipleViewRepository) {
    suspend operator fun invoke(): Resource<List<MultipleViewEntity>> {
        return multipleViewRepository.getData()
    }
}