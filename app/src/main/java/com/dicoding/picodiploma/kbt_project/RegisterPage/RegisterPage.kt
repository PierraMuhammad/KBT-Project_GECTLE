package com.dicoding.picodiploma.kbt_project.RegisterPage

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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
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
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.dicoding.picodiploma.kbt_project.ui.theme.Inter_Bold
import com.dicoding.picodiploma.kbt_project.ui.theme.Inter_Regular

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterPage(navController: NavController){
    Surface{
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
        ){
            var name by remember { mutableStateOf("") }
            var email by remember { mutableStateOf("") }
            var username by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            CloseIcon(navController)
            Text(
                text = "Daftarkan Akun\n"+"Anda",
                fontFamily = Inter_Bold,
                fontSize = 30.sp,
                lineHeight = 40.sp,
                color = Color(0xFF292929),
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Daftar dan nikmati hidup\n"+"tanpa harus khawatir dengan\n"+"kondisi anda",
                fontSize = 24.sp,
                fontFamily = Inter_Regular,
                lineHeight = 36.sp,
                letterSpacing = 0.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Name",
                fontFamily = Inter_Bold,
                fontSize = 16.sp,
                color = Color(0xFF292929)
                )
            Spacer(modifier = Modifier.height(4.dp))
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                placeholder = { Text(text = "name", fontFamily = Inter_Regular, color = Color(0xFFB6B6B6))},
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF292929),
                    unfocusedBorderColor = Color(0xFFB6B6B6)
                ),
                modifier = Modifier
                    .fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Email",
                fontFamily = Inter_Bold,
                fontSize = 14.sp,
                color = Color(0xFF292929)
            )
            Spacer(modifier = Modifier.height(4.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text(text = "email", fontFamily = Inter_Regular, color = Color(0xFFB6B6B6))},
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF292929),
                    unfocusedBorderColor = Color(0xFFB6B6B6)
                ),
                modifier = Modifier
                    .fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Username",
                fontFamily = Inter_Bold,
                fontSize = 14.sp,
                color = Color(0xFF292929)
            )
            Spacer(modifier = Modifier.height(4.dp))
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                placeholder = { Text(text = "username", fontFamily = Inter_Regular, color = Color(0xFFB6B6B6))},
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF292929),
                    unfocusedBorderColor = Color(0xFFB6B6B6)
                ),
                modifier = Modifier
                    .fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Password",
                fontFamily = Inter_Bold,
                fontSize = 14.sp,
                color = Color(0xFF292929)
            )
            Spacer(modifier = Modifier.height(4.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text(text = "password", fontFamily = Inter_Regular, color = Color(0xFFB6B6B6))},
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF292929),
                    unfocusedBorderColor = Color(0xFFB6B6B6)
                ),
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth(),

                )
            CheckboxRegister()
            Spacer(modifier = Modifier.height(40.dp))
            Divider(color = Color(0xFFB6B6B6).copy(0.5f))
            HaveAccount(navController)
            Button(
                onClick = {
                    navController.navigate("home_dashboard")
                },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF87B6D6)
                )
            ) {
                Text(
                    text = "Register",
                    fontFamily = Inter_Bold,
                    fontSize = 24.sp,
                    letterSpacing = 0.sp,
                    color = Color.White
                )
            }

        }
    }
}

@Composable
fun HaveAccount(navController: NavController){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = "Sudah punya akun?",
            fontSize = 14.sp,
            fontFamily = Inter_Regular,
            color = Color(0xFF87B6D6)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "Login aja",
            fontSize = 14.sp,
            fontFamily = Inter_Bold,
            color = Color(0xFF87B6D6),
            modifier = Modifier.clickable {
                navController.navigate("login_page")
            }
        )
    }
}
@Composable
fun CheckboxRegister(){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        var checked by remember { mutableStateOf(false) }
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it },
            colors = CheckboxDefaults.colors(
                checkedColor = Color(0xFF87B6D6),
                uncheckedColor = Color(0xFF292929)
            ))
        Text(
            text = "Saya menyetujui semua syarat & ketentuan",
            fontFamily = Inter_Regular,
            fontSize = 14.sp,
            letterSpacing = 0.sp,
            color = Color(0xFF87B6D6)
        )
    }
}