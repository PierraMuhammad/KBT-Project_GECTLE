package com.dicoding.picodiploma.kbt_project.UpdateProfile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dicoding.picodiploma.kbt_project.Component.bottomNavItems
import com.dicoding.picodiploma.kbt_project.Input.InputField
import com.dicoding.picodiploma.kbt_project.Input.TextFieldState
import com.dicoding.picodiploma.kbt_project.Input.UserState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateProfile(navController: NavController, user: UserState = remember { UserState() }){
    var selected by remember {
        mutableIntStateOf(1)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = { Text(text = "Patient", fontWeight = FontWeight.Bold) },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.navigate("home_dashboard")
                        }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "ArrowBack",
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(135, 182, 214),
                    )
                )
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
        ){
                values ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(values),
            ){
                items(1){
                    Column(
                        modifier = Modifier.fillMaxSize().padding(horizontal = 30.dp) ,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        // data nama, usia, dan nomor darurat
                        var nameState = remember { TextFieldState() }
                        var ageState = remember { TextFieldState() }
                        var numState = remember { TextFieldState() }
                        Text(text = "Detail Patient", modifier = Modifier.padding(top = 15.dp, bottom = 7.5.dp), fontSize = 18.sp, fontWeight = FontWeight.Medium)

                        InputField("Name", nameState, user.nama)
                        InputField("Usia", ageState, user.age)
                        InputField("Nomor Darurat", numState, user.phoneNumber)
                        Button(
                            onClick = {
                                user.nama = nameState.text
                                user.age = ageState.text
                                user.phoneNumber = numState.text
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(135, 182, 214),
                            )
                        ) {
                            Text(text = "Save")
                        }
                    }
                }
            }
        }
    }
}