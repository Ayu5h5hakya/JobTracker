package com.app.employeetracking.features.auth.data.datasources.remote

import retrofit2.http.POST

interface AuthApi {
    @POST
    suspend fun login()
}