package com.example.flavorsdemo.di.network

import com.example.flavorsdemo.BuildConfig
import com.example.flavorsdemo.feature.applicationtype.data.source.ApplicationTypeSource
import com.example.flavorsdemo.feature.userlist.data.source.UserSource
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BuildConfig.URL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
    }

    @Provides
    fun provideApplicationTypeSourceApi(retrofit: Retrofit): ApplicationTypeSource {
        return retrofit.create(ApplicationTypeSource::class.java)
    }

    @Provides
    fun provideUserSourceApi(retrofit: Retrofit): UserSource {
        return retrofit.create(UserSource::class.java)
    }
}