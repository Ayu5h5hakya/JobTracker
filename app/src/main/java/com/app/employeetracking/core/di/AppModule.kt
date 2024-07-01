package com.app.employeetracking.core.di

import com.app.employeetracking.features.journey.data.datasources.remote.JourneyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideJourneyApi() : JourneyApi {
        return Retrofit.Builder()
            .baseUrl("http://ec2-54-86-119-176.compute-1.amazonaws.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
}