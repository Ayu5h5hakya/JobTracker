package com.app.employeetracking.features.journey.data.repository

import android.util.Log
import com.app.employeetracking.features.journey.data.datasources.remote.JourneyApi
import com.app.employeetracking.features.journey.domain.model.Journey
import com.app.employeetracking.features.journey.domain.repository.JourneyRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JourneyRepositoryImpl @Inject constructor(private val api: JourneyApi) : JourneyRepository {
    override suspend fun getJourneyDetail(): Journey {
        return try {
            api.getJourneyDetails("", "", "")
        } catch (e: Exception) {
            throw e
        }
    }
}