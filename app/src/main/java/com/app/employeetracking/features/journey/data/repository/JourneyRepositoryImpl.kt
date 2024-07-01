package com.app.employeetracking.features.journey.data.repository

import com.app.employeetracking.core.Result
import com.app.employeetracking.features.journey.data.datasources.remote.JourneyApi
import com.app.employeetracking.features.journey.domain.model.Journey
import com.app.employeetracking.features.journey.domain.repository.JourneyRepository

class JourneyRepositoryImpl(private val api: JourneyApi) : JourneyRepository {
    override suspend fun getJourneyDetail(): Result<Journey> {
        return try {
            Result.Success<Journey>(data = api.getJourneyDetails("", "", ""))
        } catch (e: Exception) {
            Result.Error<Journey>(message = "Err")
        }
    }
}