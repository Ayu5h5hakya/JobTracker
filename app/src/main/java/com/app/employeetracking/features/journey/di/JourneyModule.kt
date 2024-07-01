package com.app.employeetracking.features.journey.di

import com.app.employeetracking.features.journey.data.repository.JourneyRepositoryImpl
import com.app.employeetracking.features.journey.domain.repository.JourneyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class JourneyModule {

    @Binds
    @Singleton
    abstract fun bindJourneyRepository(
        journeyRepositoryImpl: JourneyRepositoryImpl
    ) : JourneyRepository
}