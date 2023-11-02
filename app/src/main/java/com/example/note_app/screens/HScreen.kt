package com.example.note_app.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import java.util.UUID

data class Objekt(
var text: String,
val id: String = UUID.randomUUID().toString(),
var title: String,
 var body: String=""
)

@Composable
fun headScreen(){
    val navController = rememberNavController()
    val list = remember { mutableStateListOf<Objekt>() }
    Surface(

        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        NavHost(navController = navController, startDestination = Screen.Home.route){

            composable(route = Screen.Home.route){
                detailScreen(list = list, navController = navController)
            }
            composable(route = Screen.Detail.route){
                ListView(list = list, navController = navController)
            }
            composable(route = Screen.Edit.route){
                edit(list, navController = navController )
            }
        }

        //MainScreen(list = list)
    }
}