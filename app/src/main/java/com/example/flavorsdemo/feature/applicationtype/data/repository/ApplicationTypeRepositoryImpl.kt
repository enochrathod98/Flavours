package com.example.flavorsdemo.feature.applicationtype.data.repository

import com.example.flavorsdemo.comman.Resource
import com.example.flavorsdemo.feature.applicationtype.data.model.toEntity
import com.example.flavorsdemo.feature.applicationtype.data.source.ApplicationTypeSource
import com.example.flavorsdemo.feature.applicationtype.domain.entity.ApplicationTypeEntity
import com.example.flavorsdemo.feature.applicationtype.domain.repository.ApplicationTypeRepository
import javax.inject.Inject

class ApplicationTypeRepositoryImpl @Inject constructor(private val applicationTypeSource: ApplicationTypeSource) :
    ApplicationTypeRepository {
    override suspend fun getApplicationType(): Resource<ApplicationTypeEntity> {
        val model = applicationTypeSource.getApplicationType()
        val data = model.toEntity()
        return Resource.Success(data)
    }
}