package com.example.flavorsdemo.feature.applicationtype.domain.usecase

import com.example.flavorsdemo.comman.Resource
import com.example.flavorsdemo.feature.applicationtype.domain.entity.ApplicationTypeEntity
import com.example.flavorsdemo.feature.applicationtype.domain.repository.ApplicationTypeRepository
import javax.inject.Inject

class ApplicationTypeUseCase @Inject constructor(
    private val repository: ApplicationTypeRepository
) {
    suspend operator fun invoke(): Resource<ApplicationTypeEntity> {
        return repository.getApplicationType()
    }
}