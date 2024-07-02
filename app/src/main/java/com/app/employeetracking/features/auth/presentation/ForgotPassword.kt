package com.app.employeetracking.features.auth.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.app.employeetracking.R

@Composable
fun ForgotPassword(modifier: Modifier = Modifier) {
    Scaffold(containerColor = colorResource(R.color.purple_200)) { padding ->
        Box(
            Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                Modifier.align(
                    Alignment.TopCenter
                )
            )
            Image(
                painter = painterResource(R.drawable.forgot_graphic),
                contentDescription = null,
                Modifier.align(
                    Alignment
                        .Center
                )
            )
            Column(
                Modifier
                    .background(
                        color = colorResource(R.color.white),
                        shape = RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp)
                    )
                    .padding(16.dp)
                    .align(Alignment.BottomCenter)
            ) {
                Text("Forgot Password!")
                Text("Please Enter Your Registered Email ID")
                Spacer(Modifier.height(8.dp))
                TextField(value = "", onValueChange = {}, Modifier.fillMaxWidth())
                Spacer(Modifier.height(8.dp))
                Button(modifier = Modifier.fillMaxWidth(),onClick = {}) { }
            }
        }
    }
}