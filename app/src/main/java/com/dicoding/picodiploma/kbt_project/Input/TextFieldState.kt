package com.dicoding.picodiploma.kbt_project.Input

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import com.dicoding.picodiploma.kbt_project.ui.theme.Inter_Regular


class TextFieldState(){
    var text: String by mutableStateOf("")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(label: String, inputState : TextFieldState = remember { TextFieldState() }, value: String){
    OutlinedTextField(
        value = inputState.text,
        onValueChange = { inputState.text = it },
        shape = RoundedCornerShape(10.dp),
        label = { Text("$label", fontFamily = Inter_Regular) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xFF292929),
            unfocusedBorderColor = Color(0xFFB6B6B6)
        ),
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Composable
fun PasswordInputField(inputState : TextFieldState = remember { TextFieldState() }){
    var passwordVisibility by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = inputState.text,
        onValueChange = { inputState.text = it },
        label = { Text("Password", fontSize = 12.sp) },
        modifier = Modifier.padding(vertical = 2.5.dp).fillMaxWidth(),
        visualTransformation =  if(passwordVisibility){
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
    )
}