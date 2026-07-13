package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyApplicationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    Box(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        BusinessCard()
                    }

                }
            }
        }
    }
}

@Composable
fun BusinessCard() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF3F8)),
        contentAlignment = Alignment.Center
    ) {

        Card(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(30.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {

            Column(
                modifier = Modifier.padding(28.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    "🌸",
                    fontSize = 24.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                Image(
                    painter = painterResource(R.drawable.amber),
                    contentDescription = "Amber",
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.TopCenter,
                    modifier = Modifier
                        .size(170.dp)
                        .clip(CircleShape)
                        .border(
                            5.dp,
                            Color.White,
                            CircleShape
                        )
                        .border(
                            3.dp,
                            Color(0xFFF8AFCB),
                            CircleShape
                        )
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    "Amber Ainsley A. Garillos",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFC2185B)
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    "🌸 Software Developer 🌸",
                    fontSize = 17.sp,
                    color = Color(0xFF8E5A6B)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Divider(
                    color = Color(0xFFFFCFE1),
                    thickness = 1.dp
                )

                Spacer(modifier = Modifier.height(20.dp))

                ContactRow(
                    Icons.Default.Phone,
                    "+63 9091457196"
                )

                Spacer(modifier = Modifier.height(12.dp))

                ContactRow(
                    Icons.Default.Email,
                    "agarillos73200@liceo.edu.ph"
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    "🐱",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFC2185B)
                )

                Spacer(modifier = Modifier.height(10.dp))



                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    "ฅ^•ﻌ•^ฅ",
                    fontSize = 30.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    "Dream • Code • Create",
                    color = Color.Gray,
                    fontSize = 14.sp
                )

            }

        }

    }

}



@Composable
fun ContactRow(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFEEF5)
        ),
        shape = RoundedCornerShape(18.dp)
    ) {

        Row(
            modifier = Modifier
                .padding(15.dp)
                .clickable { },
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color(0xFFE91E63)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = label,
                fontSize = 15.sp,
                color = Color(0xFF5A4A52)
            )

        }

    }

}