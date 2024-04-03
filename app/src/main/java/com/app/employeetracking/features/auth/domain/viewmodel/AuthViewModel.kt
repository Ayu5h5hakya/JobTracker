package com.app.employeetracking.features.auth.domain.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.employeetracking.features.auth.domain.repository.AuthRepository
import com.google.firebase.Firebase
import com.google.firebase.messaging.messaging
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

//@HiltViewModel
//class AuthViewModel @Inject constructor(
//    private val repository: AuthRepository
//) : ViewModel() {
//    fun login() {
//
//        viewModelScope.launch {
//            val token = Firebase.messaging.token.await()
//            repository.login()
//        }
//    }
//}