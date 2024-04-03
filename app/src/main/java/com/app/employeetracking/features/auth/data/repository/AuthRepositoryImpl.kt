package com.app.employeetracking.features.auth.data.repository

import com.app.employeetracking.features.auth.domain.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl : AuthRepository{
    override suspend fun login() {
        withContext(Dispatchers.IO) {

        }
    }
}