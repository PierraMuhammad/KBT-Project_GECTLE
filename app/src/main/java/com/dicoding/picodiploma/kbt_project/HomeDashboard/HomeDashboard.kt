package com.dicoding.picodiploma.kbt_project.HomeDashboard

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dicoding.picodiploma.kbt_project.Input.UserState
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.dicoding.picodiploma.kbt_project.R
import com.dicoding.picodiploma.kbt_project.ui.theme.Inter_Bold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeDashboard(navController: NavController, user: UserState = remember { UserState() }, ctx: Context){
    Surface {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color(0xFF87B6D6))
                    .padding(16.dp), verticalAlignment = Alignment.CenterVertically){
                    TopAppBar(
                        title = {
                            Text(
                                text = "Welcome ${user.nama}",
                                fontFamily = Inter_Bold,
                                letterSpacing = 0.sp,
                                color = Color.White,
                            )
                        },
                        navigationIcon = {
                            IconButton(onClick = {
                                navController.navigate("update_profile")
                            }) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_avatar),
                                    contentDescription = null,
                                    modifier = Modifier.size(40.dp)
                                )
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color(0xFF87B6D6),
                        ),
                        actions = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    modifier = Modifier.size(30.dp),
                                    painter = painterResource(id = R.drawable.ic_bell),
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            }
                        }
                    )
                }
            }
        ){
                values ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(values),
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                items(1){
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ){
                        Spacer(modifier = Modifier.height(18.dp))
                        Text(
                            text = "Jangan lupa cek kondisi keluargamu!",
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            fontFamily = Inter_Bold,
                            color = Color(0xFF292929)
                        )
                    }
                }
            }
        }
    }

//    callEmergencyNumber(user.phoneNumber, ctx)
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun callEmergencyNumber(phoneNumber: String, ctx: Context){
    val scope = MainScope()
    var hasCalled by remember { mutableStateOf(false) }

    scope.launch {
        delay(30000)

        if(!hasCalled){
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:$phoneNumber")
            ctx.startActivity(intent)
            hasCalled = !hasCalled
        }
    }
}