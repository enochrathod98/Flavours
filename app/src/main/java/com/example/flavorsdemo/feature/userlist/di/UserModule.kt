package com.example.flavorsdemo.feature.userlist.di

import com.example.flavorsdemo.feature.userlist.data.repository.UserRepositoryImpl
import com.example.flavorsdemo.feature.userlist.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class UserModule {
    @Binds
    abstract fun provideRepository(repositoryImpl: UserRepositoryImpl) : UserRepository
}