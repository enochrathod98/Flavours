package com.example.flavorsdemo.feature.applicationtype.domain.repository

import com.example.flavorsdemo.comman.Resource
import com.example.flavorsdemo.feature.applicationtype.domain.entity.ApplicationTypeEntity
import dagger.Provides

interface ApplicationTypeRepository {
    suspend fun getApplicationType(): Resource<ApplicationTypeEntity>
}