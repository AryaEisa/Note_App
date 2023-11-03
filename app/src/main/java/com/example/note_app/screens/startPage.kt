package com.example.note_app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun StartPage(navController: NavController){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black))
    {
        Column(modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text(text = "Note-App", style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp
            )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate(Screen.Home.route) },
                modifier = Modifier.padding(16.dp)) {
                Icon(imageVector = Icons.Default.Add, contentDescription ="Go To Start Page" )

            }

        }
    }
}