package com.dicoding.picodiploma.kbt_project.Patient

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dicoding.picodiploma.kbt_project.Input.InputField
import com.dicoding.picodiploma.kbt_project.Input.TextFieldState
import com.dicoding.picodiploma.kbt_project.Input.UserState
import com.dicoding.picodiploma.kbt_project.ui.theme.Inter_Bold
import com.dicoding.picodiploma.kbt_project.R
import com.dicoding.picodiploma.kbt_project.ui.theme.Inter_Regular

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PatientForm(navController: NavController, user: UserState = remember { UserState() }){
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
                        navigationIcon = {
                            IconButton(onClick = {
                                navController.navigate("home_dashboard")
                            }) {
                                Icon(
                                    imageVector = Icons.Filled.ArrowBack,
                                    contentDescription = "ArrowBack",
                                    tint = Color.White,
                                    modifier = Modifier.size(30.dp)
                                )
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color(0xFF87B6D6),
                        )
                    )
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
                        // data nama, usia, dan nomor darurat
                        var nameState = remember { TextFieldState() }
                        var ageState = remember { TextFieldState() }
                        var numState = remember { TextFieldState() }
                        Column {
                            Row (
                                modifier = Modifier.padding(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.ic_patient),
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(Color(0xFF4D8FB1)),
                                    modifier = Modifier.size(44.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Detail Patient",
                                    fontFamily = Inter_Bold,
                                    fontSize = 20.sp,
                                    color = Color(0xFF4D8FB1)
                                )

                            }
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                            )
                            {
                                Column(modifier = Modifier
                                    .fillMaxSize()
                                    .padding(24.dp)) {
                                    Text(
                                        text = "Name",
                                        fontFamily = Inter_Bold,
                                        letterSpacing = 0.sp,
                                        color = Color(0xFF4D8FB1)
                                    )
                                    InputField("Name", nameState, user.nama)
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = "Age",
                                        fontFamily = Inter_Bold,
                                        letterSpacing = 0.sp,
                                        color = Color(0xFF4D8FB1)
                                    )
                                    InputField("Age", ageState, user.age)
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = "Emergency Number",
                                        fontFamily = Inter_Bold,
                                        letterSpacing = 0.sp,
                                        color = Color(0xFF4D8FB1)
                                    )
                                    InputField("Emergency Number", numState, user.phoneNumber)
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = "Foto",
                                        fontFamily = Inter_Bold,
                                        letterSpacing = 0.sp,
                                        color = Color(0xFF4D8FB1)
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Column (
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(200.dp)
                                            .border(
                                                width = 1.dp,
                                                color = Color(0xFFB6B6B6).copy(alpha = 0.7f),
                                                shape = RoundedCornerShape(8.dp)
                                            ),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(Color(0xFF87B6D6))) {
                                            Text(
                                                text = "Browse",
                                                fontFamily = Inter_Bold
                                            )
                                        }
                                    }
                                }
                            }
                        }
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
                                fontSize = 20.sp,
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
fun PreviewPatientForm(){
    val navController = rememberNavController()
    PatientForm(navController)
}