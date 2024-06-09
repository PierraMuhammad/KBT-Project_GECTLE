package com.dicoding.picodiploma.kbt_project.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dicoding.picodiploma.kbt_project.R
import com.dicoding.picodiploma.kbt_project.ui.theme.Inter_Bold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PatientCard(){
  Box(
      modifier = Modifier
          .graphicsLayer {
              shadowElevation = 4.dp.toPx() // Mengatur ketinggian bayangan
              shape = RoundedCornerShape(8.dp)
              clip = true
              translationY = 8.dp.toPx() // Mengatur offset vertikal bayangan
          }
  ){
      Row(
          modifier = Modifier
              .fillMaxWidth()
              .height(120.dp)
              .background(
                  color = Color.White,
                  shape = RoundedCornerShape(8.dp)
              )
              .padding(16.dp),
          verticalAlignment = Alignment.CenterVertically,
      ) {
          Image(painter = painterResource(id = R.drawable.ic_patients), contentDescription = null, modifier = Modifier.size(80.dp))
          Spacer(modifier = Modifier.width(14.dp))
          Column {
              Text(
                  text = "Sunari - 65 Tahun",
                  fontFamily = Inter_Bold,
                  fontSize = 20.sp
              )
              Text(
                  text = "Kakek",
                  fontFamily = Inter_Bold,
                  fontSize = 16.sp
              )
              Spacer(modifier = Modifier.height(8.dp))
              Text(
                  text = "Aman",
                  textAlign = TextAlign.Center,
                  fontFamily = Inter_Bold,
                  fontSize = 14.sp,
                  color = Color(0xFF026B26),
                  modifier = Modifier
                      .background(
                          Color(0xFFCAFFD3),
                          shape = RoundedCornerShape(6.dp)
                      )
                      .width(70.dp)
                      .padding(4.dp),

                  )
          }
      }
  }
}

@Preview
@Composable
fun PreviewPatientCard(){
    PatientCard()
}