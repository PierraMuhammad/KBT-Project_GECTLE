package com.dicoding.picodiploma.kbt_project.Input

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class TextFieldState(){
    var text: String by mutableStateOf("")
}

@Composable
fun InputField(label: String, inputState : TextFieldState = remember { TextFieldState() }, value: String){
    OutlinedTextField(
        value = inputState.text,
        onValueChange = { inputState.text = it },
        label = { Text("$label", fontSize = 12.sp) },
        modifier = Modifier.padding(vertical = 2.5.dp).fillMaxWidth(),
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