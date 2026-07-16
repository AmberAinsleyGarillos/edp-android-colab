package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.ProfileTheme
import androidx.compose.ui.graphics.vector.ImageVector


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileTheme {

                Scaffold(

                    containerColor = MaterialTheme.colorScheme.surface,

                    topBar = {
                        TopAppBar(

                            title = {
                                Text(
                                    text = "My Profile",
                                    style = MaterialTheme.typography.titleLarge
                                )
                            },

                            navigationIcon = {
                                IconButton(onClick = {}) {
                                    Icon(Icons.Default.Menu, contentDescription = "Menu")
                                }
                            },

                            actions = {
                                IconButton(onClick = {}) {
                                    Icon(Icons.Default.MoreVert, contentDescription = "More")
                                }
                            },

                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                                navigationIconContentColor = MaterialTheme.colorScheme.primary,
                                actionIconContentColor = MaterialTheme.colorScheme.primary
                            )

                        )
                    },

                    floatingActionButton = {
                        FloatingActionButton(

                            onClick = {},

                            containerColor = MaterialTheme.colorScheme.primary,

                            contentColor = MaterialTheme.colorScheme.onPrimary

                        ) {

                            Icon(Icons.Default.Add, contentDescription = "Add")

                        }
                    }

                ) { padding ->

                    Column(

                        modifier = Modifier
                            .padding(padding)
                            .padding(horizontal = 24.dp, vertical = 20.dp)
                            .fillMaxSize(),

                        horizontalAlignment = Alignment.CenterHorizontally,

                        verticalArrangement = Arrangement.spacedBy(20.dp)

                    ) {

                        // Avatar Box
                        Box(
                            modifier = Modifier.size(130.dp),
                            contentAlignment = Alignment.Center
                        ) {

                            Box(
                                modifier = Modifier
                                    .size(120.dp)
                                    .clip(CircleShape)
                                    .background(MaterialTheme.colorScheme.primaryContainer)
                                    .border(
                                        4.dp,
                                        MaterialTheme.colorScheme.primary,
                                        CircleShape
                                    )
                            )

                            Box(
                                modifier = Modifier
                                    .align(Alignment.BottomEnd)
                                    .size(22.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFF7ED957))
                                    .border(2.dp, Color.White, CircleShape)
                            )

                        }

                        Text(
                            "Amber Ainsley A. Garillos",
                            style = MaterialTheme.typography.headlineSmall
                        )

                        Text(
                            "BSIT-3 Student",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {

                            Button(
                                onClick = {},
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("Message")
                            }

                            OutlinedButton(
                                onClick = {},
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("Follow")
                            }

                        }

                        // Stats Card

                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(20.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer
                            )
                        ) {

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {

                                Stat("120", "Posts")
                                Stat("1.5K", "Followers")
                                Stat("450", "Following")

                            }

                        }

                        // Contact Card

                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(20.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer
                            )
                        ) {

                            Column(
                                modifier = Modifier.padding(20.dp),
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {

                                Contact(Icons.Default.Email, "agarillos73200@liceo.edu.ph")
                                Contact(Icons.Default.Phone, "+63 9091457196")
                                Contact(Icons.Default.LocationOn, "Cagayan de Oro City")

                            }

                        }

                    }

                }

            }
                    }
                }
                }

@Composable
fun Contact(
    icon: ImageVector,
    text: String
) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium
        )

    }
}

@Composable
fun Stat(
    number: String,
    label: String
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = number,
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}

@Composable
fun Greeting(x0: String) {
    TODO("Not yet implemented")
}