package com.app.employeetracking.features.auth.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.app.employeetracking.R

@Composable
fun Login(modifier: Modifier = Modifier) {
    Scaffold(containerColor = colorResource(R.color.purple_200)) { padding ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.align(
                    Alignment.TopCenter
                )
            )
            Image(
                painter = painterResource(R.drawable.login_graphic),
                contentDescription = null,
                modifier = Modifier.align(
                    Alignment.Center
                )
            )
            Column(
                Modifier
                    .background(
                        color = colorResource(R.color.white),
                        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                    )
                    .padding(16.dp)
                    .align(Alignment.BottomCenter)
            ) {
                Row {
                    Text("Welcome Back!", Modifier.weight(1f))
                    Text("English")
                }
                Text("Login to Your Existing Employee Management Account.")
                Spacer(Modifier.height(16.dp))
                TextField(value = "", onValueChange = {}, Modifier.fillMaxWidth())
                Spacer(Modifier.height(8.dp))
                TextField(value = "", onValueChange = {}, Modifier.fillMaxWidth())
                Spacer(Modifier.height(8.dp))
                Text(
                    "Forgot Password?",
                    Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End
                )
                Spacer(Modifier.height(8.dp))
                Button(modifier = Modifier.fillMaxWidth(),onClick = {}) { }
            }
        }
    }
}