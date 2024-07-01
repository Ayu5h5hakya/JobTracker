package com.app.employeetracking.features.dashboard.di

import com.app.employeetracking.features.dashboard.data.datasources.local.EmployeeRepositoryImpl
import com.app.employeetracking.features.dashboard.domain.repository.EmployeeRepository
import com.app.employeetracking.features.journey.data.repository.JourneyRepositoryImpl
import com.app.employeetracking.features.journey.domain.repository.JourneyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class EmployeeModule {

    @Binds
    @Singleton
    abstract fun bindEmployeeRepository(
        employeeRepositoryImpl: EmployeeRepositoryImpl
    ) : EmployeeRepository
}