package com.example.note_app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ListView(list: MutableList<Objekt>, navController: NavController) {

Column (modifier = Modifier
    .padding(16.dp)
    .background(color = Color.DarkGray)
    .fillMaxSize()) {
    Row (modifier = Modifier.padding(16.dp)){
        Button(onClick = { navController.navigate(Screen.Home.route) }) {
            Text(text = "Back")
        }
            Row {
                Button(onClick = { navController.navigate(Screen.Edit.route)}) {
                    Text(text = "open-for-edit")

                }


        }
    }
    LazyColumn{
        items(list){ThisObject ->
            Row {
                Column (modifier = Modifier
                    .padding(10.dp)
                    .background(Color.LightGray)){

                    Column {
                        Row {
                            Text(text = "Title: ")
                            Text(text = ThisObject.title, style = TextStyle(color = Color.White), modifier = Modifier
                                .background(
                                    Color.Black
                                )
                                .fillMaxSize() )
                        }
                        Row {
                            Text(text = "Note: ")
                            Text(text = ThisObject.text, style = TextStyle(color = Color.White), modifier = Modifier
                                .background(
                                    Color.Black
                                )
                                .fillMaxSize() )
                        }
                    Row {
                        Button(onClick = {list.remove(ThisObject)}) {
                            Text(text = "Delete")
                        }
                        Button(onClick = {
                            navController.navigate(Screen.showNote.route)})
                            {
                            Text(text = "Read")
                        }

                        }
                    }
                }
            }
        }
    }
}
}








