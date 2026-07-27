package com.example.myapplication

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
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

// Maroon Colors
val Maroon = Color(0xFF800000)
val LightMaroon = Color(0xFFB03060)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {

    val isDark = isSystemInDarkTheme()

    val titleColor = if (isDark) Color.White else Maroon
    val subtitleColor = if (isDark) Color.LightGray else Color.DarkGray
    val valueColor = if (isDark) Color.White else Color.Black
    val labelColor = if (isDark) Color(0xFFBDBDBD) else Color.Gray

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "My Profile",
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Menu, null, tint = Color.White)
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.MoreVert, null, tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Maroon
                )
            )
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

                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .background(LightMaroon)
                        .border(4.dp, Maroon, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "AG",
                        color = Color.White,
                        style = MaterialTheme.typography.headlineMedium
                    )
                }

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(22.dp)
                        .clip(CircleShape)
                        .background(Color.Green)
                )

            }

            Text(
                text = "AMBER AINSLEY A. GARILLOS",
                style = MaterialTheme.typography.headlineSmall,
                color = titleColor
            )

            Text(
                text = "BSIT 3-1",
                color = subtitleColor
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {

                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    InfoRow(
                        icon = Icons.Default.Person,
                        label = "Full Name",
                        value = "Amber Ainsley Anas Garillos",
                        labelColor = labelColor,
                        valueColor = valueColor
                    )

                    InfoRow(
                        icon = Icons.Default.Person,
                        label = "Course",
                        value = "Bachelor of Science in Information Technology",
                        labelColor = labelColor,
                        valueColor = valueColor
                    )

                    InfoRow(
                        icon = Icons.Default.Person,
                        label = "Section",
                        value = "BSIT 3-1",
                        labelColor = labelColor,
                        valueColor = valueColor
                    )

                    InfoRow(
                        icon = Icons.Default.Phone,
                        label = "Mobile Number",
                        value = "+63 9091457196",
                        labelColor = labelColor,
                        valueColor = valueColor
                    )

                    InfoRow(
                        icon = Icons.Default.Email,
                        label = "Email Address",
                        value = "agarillos73200@liceo.edu.ph",
                        labelColor = labelColor,
                        valueColor = valueColor
                    )
                }
            }
        }
    }
}

@Composable
fun InfoRow(
    icon: ImageVector,
    label: String,
    value: String,
    labelColor: Color,
    valueColor: Color
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = Maroon
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {

            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = labelColor
            )

            Text(
                text = value,
                style = MaterialTheme.typography.bodyLarge,
                color = valueColor
            )
        }
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