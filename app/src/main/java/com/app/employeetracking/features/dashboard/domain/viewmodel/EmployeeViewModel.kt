package com.app.employeetracking.features.dashboard.domain.viewmodel

import androidx.lifecycle.ViewModel
import com.app.employeetracking.features.dashboard.domain.repository.EmployeeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EmployeeViewModel @Inject constructor(
    private val repository : EmployeeRepository
) : ViewModel(){

    suspend fun isUserLoggedIn() : Boolean {
        return repository.isTokenValid()
    }

}