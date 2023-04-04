package com.example.flavorsdemo.feature.applicationtype.di

import com.example.flavorsdemo.feature.applicationtype.data.repository.ApplicationTypeRepositoryImpl
import com.example.flavorsdemo.feature.applicationtype.domain.repository.ApplicationTypeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class ApplicationTypeModule {
    @Binds
    abstract fun provideRepository(repositoryImpl: ApplicationTypeRepositoryImpl) : ApplicationTypeRepository
}