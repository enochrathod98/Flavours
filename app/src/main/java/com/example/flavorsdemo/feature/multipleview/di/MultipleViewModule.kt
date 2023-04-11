package com.example.flavorsdemo.feature.multipleview.di

import com.example.flavorsdemo.feature.multipleview.data.repository.MultipleViewRepositoryImpl
import com.example.flavorsdemo.feature.multipleview.domain.repository.MultipleViewRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class MultipleViewModule {
    @Binds
    abstract fun provideRepository(multipleViewRepositoryImpl: MultipleViewRepositoryImpl): MultipleViewRepository
}