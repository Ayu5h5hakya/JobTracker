package com.app.employeetracking.features.profile.presentation

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.app.employeetracking.R
import com.app.employeetracking.core.composables.OptionModal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(modifier: Modifier = Modifier) {

    var pfpImage by remember { mutableStateOf("") }
    var showImageProviderSheet by remember { mutableStateOf(false) }
    var sheetState = rememberModalBottomSheetState()

    val galleryLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let {
            pfpImage = uri.toString()
        }
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            showImageProviderSheet = true
//            galleryLauncher.launch("image/*")
        }
    )

    Column(
        modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.purple_200)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .size(100.dp)
                .clickable {
                    permissionLauncher.launch(Manifest.permission.CAMERA)
                }
        ) {
            if (pfpImage.isNullOrEmpty()) {
                Image(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(100.dp)
                        .clip(CircleShape),
                    painter = painterResource(R.drawable.editprofile),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
            } else {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(pfpImage)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clip(CircleShape)
                )
            }
            Image(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(24.dp)
                    .background(shape = CircleShape, color = colorResource(R.color.white)),
                painter = painterResource(R.drawable.profilechngicon),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
        }
        if (showImageProviderSheet) {
            OptionModal(options = listOf("camera", "gallery")) { option: String ->
                showImageProviderSheet = false
                when (option) {
                    "camera" -> {}
                    "gallery" -> {
                        galleryLauncher.launch("image/*")
                    }
                }
            }
        }
    }
}