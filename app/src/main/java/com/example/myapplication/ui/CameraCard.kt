package com.example.myapplication.ui

import android.Manifest
import android.util.Log

import androidx.camera.core.Camera
import androidx.camera.core.ImageCapture

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

import com.example.myapplication.hardware.CameraPreview
import com.example.myapplication.hardware.buzz
import com.example.myapplication.hardware.isShake
import com.example.myapplication.hardware.loadThumb
import com.example.myapplication.hardware.rememberAccelerometer
import com.example.myapplication.hardware.takePhoto

import com.example.myapplication.permissions.PermStatus
import com.example.myapplication.permissions.PermissionState
import com.example.myapplication.permissions.openAppSettings
import com.example.myapplication.permissions.rememberPermission

import java.io.File

@Composable
fun CameraCard() {
    val context = LocalContext.current

    val camera = rememberPermission(
        Manifest.permission.CAMERA
    )

    val capture = remember {
        ImageCapture.Builder().build()
    }

    var photo by remember {
        mutableStateOf<File?>(null)
    }

    // Bonus: keep reference to the open CameraX camera
    var cam by remember {
        mutableStateOf<Camera?>(null)
    }

    // Bonus: torch state
    var torchOn by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Text(
                "Field photo",
                style = MaterialTheme.typography.titleMedium
            )

            PermissionGate(
                state = camera,
                feature = "Camera",
                reason = "We need the camera to photograph the issue you report."
            ) {

                // Camera preview
                CameraPreview(
                    capture = capture,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp),
                    onCameraReady = {
                        cam = it
                    }
                )

                // Take photo
                Button(
                    onClick = {
                        takePhoto(context, capture) { saved ->
                            photo = saved
                        }
                    }
                ) {
                    Text("Take photo")
                }

                // Torch bonus
                if (cam?.cameraInfo?.hasFlashUnit() == true) {
                    Button(
                        onClick = {
                            torchOn = !torchOn
                            cam?.cameraControl?.enableTorch(torchOn)
                        }
                    ) {
                        Text(
                            if (torchOn) {
                                "Torch off"
                            } else {
                                "Torch on"
                            }
                        )
                    }
                }

                // Show saved filename
                photo?.let {
                    Text("Saved: ${it.name}")
                }

                // Shake capture bonus
                val shake = rememberAccelerometer()

                var lastShot by remember {
                    mutableLongStateOf(0L)
                }

                LaunchedEffect(shake) {
                    val now = System.currentTimeMillis()

                    if (
                        isShake(shake) &&
                        now - lastShot > 1500
                    ) {
                        lastShot = now

                        takePhoto(context, capture) {
                            photo = it
                        }

                        context.buzz()

                        Log.d(
                            "FieldKit",
                            "Shake capture"
                        )
                    }
                }
            }

            // Thumbnail
            photo?.let { file ->
                val thumb = remember(file) {
                    loadThumb(file)
                }

                thumb?.let {
                    Image(
                        bitmap = it,
                        contentDescription = "Last photo",
                        modifier = Modifier.size(96.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun PermissionGate(
    state: PermissionState,
    feature: String,
    reason: String,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        when (state.status) {

            PermStatus.Granted -> {
                content()
            }

            PermStatus.NotAsked -> {
                Button(
                    onClick = state.request
                ) {
                    Text("Allow $feature")
                }
            }

            PermStatus.NeedsRationale -> {
                Text(reason)

                Button(
                    onClick = state.request
                ) {
                    Text("Try again")
                }
            }

            PermStatus.Denied -> {
                Text(
                    "$feature is blocked. Turn it on in Settings."
                )

                Button(
                    onClick = {
                        context.openAppSettings()
                    }
                ) {
                    Text("Open Settings")
                }
            }
        }
    }
}