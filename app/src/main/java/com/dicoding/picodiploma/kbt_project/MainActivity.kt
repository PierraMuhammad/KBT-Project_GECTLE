package com.dicoding.picodiploma.kbt_project

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dicoding.picodiploma.kbt_project.HomeDashboard.HomeDashboard
import com.dicoding.picodiploma.kbt_project.Input.UserState
import com.dicoding.picodiploma.kbt_project.LandingPage.LandingPage
import com.dicoding.picodiploma.kbt_project.LoginPage.LoginPage
import com.dicoding.picodiploma.kbt_project.RegisterPage.RegisterPage
import com.dicoding.picodiploma.kbt_project.UpdateProfile.UpdateProfile
import com.dicoding.picodiploma.kbt_project.ui.theme.KBTProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        checkPermission()
        super.onCreate(savedInstanceState)
        setContent {
            KBTProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingPreview()
                }
            }
        }
    }

    fun checkPermission() {
        if (ContextCompat.checkSelfPermission(this@MainActivity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(Manifest.permission.CALL_PHONE), 42)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KBTProjectTheme {
        var ctx = LocalContext.current
        var user = remember { UserState() }
        var navController = rememberNavController()
        NavHost(navController = navController, startDestination = "landing_page") {
            composable("update_profile"){
                UpdateProfile(navController, user)
            }

            composable("home_dashboard"){
                HomeDashboard(navController, user, ctx)
            }

            composable("login_page"){
                LoginPage(navController)
            }

            composable("landing_page"){
                LandingPage(navController)
            }

            composable("register_page"){
                RegisterPage(navController)
            }
        }
    }
}