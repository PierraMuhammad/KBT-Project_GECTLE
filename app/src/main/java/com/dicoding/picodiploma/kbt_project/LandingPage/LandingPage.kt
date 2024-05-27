package com.dicoding.picodiploma.kbt_project.LandingPage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LandingPage(navController: NavController){
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 28.dp),
            verticalArrangement = Arrangement.Center,
        ){
            Text(
                text = "Selamat Datang di Gectle App!",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                lineHeight = 40.sp,
            )
            Text(
                text = "Masuk atau daftar sekarang untuk menikmati kemudahan memantau kesehatan lansia dan penderita epilepsi, melacak kondisi kesehatan secara real-time dengan aplikasi kami.",
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .padding(bottom = 20.dp),
                lineHeight = 20.sp,
            )
            Button(
                onClick = { navController.navigate("login_page") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(135, 182, 214),
                )
            ) {
                Text(text = "Login")
            }
            Button(
                onClick = { navController.navigate("register_page") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                ),
                border = BorderStroke(2.dp, Color(135, 182, 214))
            ) {
                Text(text = "Register", color = Color(135, 182, 214))
            }
        }
    }
}