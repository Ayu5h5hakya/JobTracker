package com.app.employeetracking.features.journey.data.datasources.remote

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface JourneyApi {
    @GET
    suspend fun getJourneyDetails(
        @Query("user_id") userId: String,
        @Query("language") langCode: String,
        @Query("mobiledate") date: String
    ) : ResponseBody
}