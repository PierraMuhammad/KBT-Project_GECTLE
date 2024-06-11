package com.dicoding.picodiploma.kbt_project.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dicoding.picodiploma.kbt_project.Component.bottomNavItems
import com.dicoding.picodiploma.kbt_project.ui.theme.Inter_Bold
import com.dicoding.picodiploma.kbt_project.R
import com.dicoding.picodiploma.kbt_project.ui.theme.Inter_Regular

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    var selected by rememberSaveable {
        mutableIntStateOf(2)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0XFFF6FAFE)
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                    Column(
                        modifier = Modifier
                            .height(240.dp)
                            .background(Color(0xFF87B6D6))
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 16.dp),
                                    contentAlignment = Alignment.Center,
                                ) {
                                    Text(
                                        text = "Profile",
                                        fontFamily = Inter_Bold,
                                        fontSize = 30.sp,
                                        color = Color.White
                                    )
                                }
                        Image(painter = painterResource(id = R.drawable.ic_profil), contentDescription = "Profile Picture", modifier = Modifier.size(130.dp))
                    }
            },
            bottomBar = {
                NavigationBar {
                    bottomNavItems.forEachIndexed { index, bottomNavItem ->
                        NavigationBarItem(
                            selected = index == selected ,
                            onClick = {
                                selected = index
                                navController.navigate(bottomNavItem.route)
                            },
                            icon = {
                                Icon(
                                    imageVector =
                                    if (index == selected)
                                        bottomNavItem.selectedIcon
                                    else
                                        bottomNavItem.unselectedIcon,
                                    contentDescription = bottomNavItem.title)
                            },
                            label = { Text(text = bottomNavItem.title)}
                        )
                    }
                }
            }
        ) { values ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(values)
            ) {
                items(1){
                    Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(28.dp)
                ) {
                        var name by remember { mutableStateOf("") }
                        var email by remember { mutableStateOf("") }
                        var username by remember { mutableStateOf("") }
                        var password by remember { mutableStateOf("") }
                    Text(
                        text = "Name",
                        fontFamily = Inter_Bold,
                        fontSize = 16.sp,
                        color = Color(0xFF292929)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        placeholder = { Text(text = "name", fontFamily = Inter_Regular, color = Color(0xFFB6B6B6))},
                        shape = RoundedCornerShape(10.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                              focusedBorderColor = Color(0xFF292929),
                              unfocusedBorderColor = Color(0xFFB6B6B6),
                              cursorColor = Color(0xFFB6B6B6)
                            ),
                        modifier = Modifier
                              .fillMaxWidth(),
                        singleLine = true
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                            text = "Email",
                            fontFamily = Inter_Bold,
                            fontSize = 16.sp,
                            color = Color(0xFF292929)
                        )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            placeholder = { Text(text = "email", fontFamily = Inter_Regular, color = Color(0xFFB6B6B6))},
                            shape = RoundedCornerShape(10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color(0xFF292929),
                                unfocusedBorderColor = Color(0xFFB6B6B6),
                                cursorColor = Color(0xFFB6B6B6)
                            ),
                            modifier = Modifier
                                .fillMaxWidth(),
                            singleLine = true
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Username",
                            fontFamily = Inter_Bold,
                            fontSize = 16.sp,
                            color = Color(0xFF292929)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        OutlinedTextField(
                            value = username,
                            onValueChange = { username = it },
                            placeholder = { Text(text = "username", fontFamily = Inter_Regular, color = Color(0xFFB6B6B6))},
                            shape = RoundedCornerShape(10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color(0xFF292929),
                                unfocusedBorderColor = Color(0xFFB6B6B6),
                                cursorColor = Color(0xFFB6B6B6)
                            ),
                            modifier = Modifier
                                .fillMaxWidth(),
                            singleLine = true
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Password",
                            fontFamily = Inter_Bold,
                            fontSize = 16.sp,
                            color = Color(0xFF292929)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            placeholder = { Text(text = "password", fontFamily = Inter_Regular, color = Color(0xFFB6B6B6))},
                            shape = RoundedCornerShape(10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color(0xFF292929),
                                unfocusedBorderColor = Color(0xFFB6B6B6),
                                cursorColor = Color(0xFFB6B6B6)
                            ),
                            visualTransformation = PasswordVisualTransformation(),
                            modifier = Modifier
                                .fillMaxWidth(),
                            singleLine = true
                        )
                        Spacer(modifier = Modifier.height(24.dp))
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
                                text = "Save",
                                fontFamily = Inter_Bold,
                                fontSize = 18.sp,
                                letterSpacing = 0.sp,
                                color = Color.White
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Divider(color = Color(0xFFB6B6B6).copy(0.5f))
                        Spacer(modifier = Modifier.height(20.dp))
                        Button(
                            onClick = {
                                navController.navigate("login_page")
                            },
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp),
                            colors = ButtonDefaults.buttonColors(Color(0xFFD68787)
                            )
                        ) {
                            Text(
                                text = "Sign Out",
                                fontFamily = Inter_Bold,
                                fontSize = 18.sp,
                                letterSpacing = 0.sp,
                                color = Color.White
                            )
                        }
                }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewProfileScreen(){
    val navController = rememberNavController()
    ProfileScreen(navController)
}