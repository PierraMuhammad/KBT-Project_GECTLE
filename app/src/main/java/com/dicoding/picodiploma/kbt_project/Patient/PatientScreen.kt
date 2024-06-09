package com.dicoding.picodiploma.kbt_project.Patient

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dicoding.picodiploma.kbt_project.Component.PatientCard
import com.dicoding.picodiploma.kbt_project.Component.bottomNavItems
import com.dicoding.picodiploma.kbt_project.Input.InputField
import com.dicoding.picodiploma.kbt_project.Input.TextFieldState
import com.dicoding.picodiploma.kbt_project.Input.UserState
import com.dicoding.picodiploma.kbt_project.ui.theme.Inter_Bold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PatientScreen(navController: NavController){
    var selected by rememberSaveable {
        mutableIntStateOf(1)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .background(Color(0xFF87B6D6))
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TopAppBar(
                        title = {
                            Text(
                                text = "Patient",
                                fontFamily = Inter_Bold,
                                color = Color.White
                            )
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color(0xFF87B6D6),
                        )
                    )
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
                            label = { Text(text = bottomNavItem.title) }
                        )
                    }
                }
            },
            floatingActionButton = {
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF87B6D6))
                        .clickable { /*TODO*/ }
                    ,
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "Add", tint = Color.White, modifier = Modifier.size(36.dp))
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
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 30.dp) ,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Daftar Pasien",
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            fontFamily = Inter_Bold,
                            color = Color(0xFF292929)
                        )
                        PatientCard()
                        Spacer(modifier = Modifier.height(16.dp))
                        PatientCard()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewPatientScreen(){
    val navController = rememberNavController()
    PatientScreen(navController)
}