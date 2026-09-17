package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.CameraCard
import com.example.myapplication.ui.LevelCard
import com.example.myapplication.ui.LocationCard

private val theme: Any
    get() {
        TODO()
    }

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            MyApplicationTheme {
                Scaffold { inner ->

                    Column(
                        Modifier
                            .padding(inner)
                            .padding(16.dp)
                            .verticalScroll(
                                rememberScrollState()
                            ),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {

                        Text(
                            "LiceoFieldKit",
                            style = MaterialTheme.typography.headlineSmall
                        )

                        LevelCard()

                        CameraCard()

                        LocationCard()
                    }
                }
            }
        }
    }
}