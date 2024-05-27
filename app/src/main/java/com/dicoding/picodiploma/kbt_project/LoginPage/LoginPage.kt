package com.dicoding.picodiploma.kbt_project.LoginPage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dicoding.picodiploma.kbt_project.Component.CloseIcon
import com.dicoding.picodiploma.kbt_project.Input.InputField
import com.dicoding.picodiploma.kbt_project.Input.PasswordInputField
import com.dicoding.picodiploma.kbt_project.Input.TextFieldState

@Composable
fun LoginPage(navController: NavController){
    Surface{
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
        ){
            var username = remember { TextFieldState() }
            var password = remember { TextFieldState() }

            CloseIcon(navController)

            Text(
                text = "Mari Login ke Akun Anda",
                fontSize = 36.sp,
                lineHeight = 40.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
            )

            Text(
                text = "Selamat Datang",
                fontSize = 16.sp,
                lineHeight = 40.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(bottom = 30.dp)
            )

            InputField("Username", username, "")
            PasswordInputField(password)

            Button(
                onClick = {
                          navController.navigate("home_dashboard")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(135, 182, 214),
                )
            ) {
                Text(text = "Save")
            }

            NotHaveAccount(navController)
        }
    }
}

@Composable
fun NotHaveAccount(navController: NavController){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = "Belum punya akun?",
            fontSize = 12.sp,
            color = Color(135, 182, 214),
            fontWeight = FontWeight.Normal
        )
        Text(
            text = "Daftar dulu",
            fontSize = 12.sp,
            color = Color(135, 182, 214),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable {
                navController.navigate("register_page")
            }
        )
    }
}