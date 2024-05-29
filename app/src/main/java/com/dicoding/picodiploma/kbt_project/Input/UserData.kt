package com.dicoding.picodiploma.kbt_project.Input

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class UserState(){
    var nama: String by mutableStateOf("Roger")
    var age: String by mutableStateOf("86")
    var phoneNumber: String by mutableStateOf("087789705420")
}