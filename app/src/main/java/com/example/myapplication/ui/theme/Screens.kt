package com.example.myapplication.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.CardPink
import com.example.myapplication.PinkLight
import com.example.myapplication.PinkPrimary
import com.example.myapplication.TextPink

@Composable
fun HomeScreen(
    onShowGreeting: (String) -> Unit
) {
    var name by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(PinkLight, CardPink)
                )
            )
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .align(Alignment.Center),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = CardPink
            ),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {

            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Greeting App",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPink
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Enter your name below",
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(20.dp))

                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = {
                        Text("Type your name")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        onShowGreeting(name)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PinkPrimary
                    )
                ) {
                    Text(
                        text = "Show Greeting",
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingScreen(
    userName: String,
    onBack: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(PinkLight, CardPink)
                )
            )
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .align(Alignment.Center),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = CardPink
            ),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {

            Column(
                modifier = Modifier.padding(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "GREETING APP",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPink
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Hello, $userName!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPink
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Welcome to Jetpack Navigation.",
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(28.dp))

                Button(
                    onClick = onBack,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PinkPrimary
                    )
                ) {
                    Text(
                        text = "Back",
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}
