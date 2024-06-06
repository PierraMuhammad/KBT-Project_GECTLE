package com.dicoding.picodiploma.kbt_project.LandingPage

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dicoding.picodiploma.kbt_project.R
import com.dicoding.picodiploma.kbt_project.ui.theme.Inter_Bold
import com.dicoding.picodiploma.kbt_project.ui.theme.Inter_Regular

@Composable
fun LandingPage(navController: NavController){
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.height(60.dp))
            Image(
                modifier = Modifier
                    .size(370.dp),
                painter = painterResource(id = R.drawable.wl_auth ),
                contentDescription = null
            )
            Text(
                text = "Selamat Datang di Gectle App!",
                fontSize = 32.sp,
                fontFamily = Inter_Bold ,
                textAlign = TextAlign.Center,
                lineHeight = 36.sp,
                letterSpacing = 0.sp,
                color = Color(0xFF292929)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Masuk atau daftar sekarang untuk menikmati kemudahan memantau kesehatan lansia dan penderita epilepsi, melacak kondisi kesehatan\n" +"secara real-time dengan aplikasi kami.",
                fontSize = 12.sp,
                fontFamily = Inter_Regular,
                color = Color(0xFFB6B6B6),
                textAlign = TextAlign.Center,
                lineHeight = 20.sp,
            )
            Spacer(modifier = Modifier.height(70.dp))
            Button(
                onClick = { navController.navigate("login_page") },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF87B6D6),
                )
            ) {
                Text(
                    text = "Login",
                    fontFamily = Inter_Bold,
                    fontSize = 18.sp,
                    letterSpacing = 0.sp,
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { navController.navigate("register_page") },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(Color.White),
                border = BorderStroke(1.dp, Color(0xFF87B6D6))
            ) {
                Text(
                    text = "Register",
                    fontFamily = Inter_Bold,
                    fontSize = 18.sp,
                    letterSpacing = 0.sp,
                    color = Color(0xFF87B6D6)
                )
            }
        }
    }
}