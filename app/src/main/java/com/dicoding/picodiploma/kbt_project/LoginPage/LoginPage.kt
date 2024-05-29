      package com.dicoding.picodiploma.kbt_project.LoginPage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.dicoding.picodiploma.kbt_project.ui.theme.Inter_Bold
import com.dicoding.picodiploma.kbt_project.ui.theme.Inter_Regular

      @Composable
fun LoginPage(navController: NavController){
    Surface{
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(28.dp),
        ){
            var username = remember { TextFieldState() }
            var password = remember { TextFieldState() }

            CloseIcon(navController)

            Text(
                text = "Mari Login ke\n" + "Akun Anda",
                fontSize = 40.sp,
                fontFamily = Inter_Bold,
                letterSpacing = 0.sp,
                lineHeight = 50.sp,
                color = Color(0xFF292929)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Selamat Datang\n" + "Kembali!",
                fontFamily = Inter_Regular,
                fontSize = 30.sp,
                lineHeight = 40.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(bottom = 30.dp)
            )

            InputField("Username", username, "")
            PasswordInputField(password)
            NotHaveAccount(navController)
            Button(
                onClick = {
                          navController.navigate("home_dashboard")
                },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF87B6D6),
                )
            ) {
                Text(text = "Login")
            }


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
        Spacer(modifier = Modifier.width(10.dp))
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