package com.example.myapplication

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.ProfileTheme
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.example.myapplication.R
import androidx.compose.ui.layout.ContentScale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {

    Scaffold(

        containerColor = MaterialTheme.colorScheme.surface,

        topBar = {

            TopAppBar(

                title = {
                    Text("My Profile")
                },

                navigationIcon = {

                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Menu, null)
                    }

                },

                actions = {

                    IconButton(onClick = {}) {
                        Icon(Icons.Default.MoreVert, null)
                    }

                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )

            )

        },

        floatingActionButton = {

            FloatingActionButton(
                onClick = {}
            ) {

                Icon(Icons.Default.Add, null)

            }

        }

    ) { padding ->

        Column(

            modifier = Modifier
                .padding(padding)
                .padding(20.dp)
                .fillMaxSize(),

            horizontalAlignment = Alignment.CenterHorizontally,

            verticalArrangement = Arrangement.spacedBy(20.dp)

        ) {

            Box(
                modifier = Modifier.size(130.dp),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.amber),
                    contentDescription = "Profile Picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(280.dp)
                        .clip(CircleShape)
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
                        .background(Color.Green)
                        .border(2.dp, Color.White, CircleShape)
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(22.dp)
                        .clip(CircleShape)
                        .background(Color.Green)
                )

            }

            Text(
                "Amber Ainsley A. Garillos",
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                "BSIT-3 Student",
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
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

                    Stat("105", "Posts")
                    Stat("1.5K", "Followers")
                    Stat("452", "Following")

                }

            }

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

@Composable
fun Contact(
    icon: ImageVector,
    text: String
) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(icon, null)

        Spacer(modifier = Modifier.width(8.dp))

        Text(text)

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
            number,
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            label,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

    }

}

@Preview(showBackground = true)
@Composable
fun LightPreview() {
    ProfileTheme {
        ProfileScreen()
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun DarkPreview() {
    ProfileTheme {
        ProfileScreen()
    }
}