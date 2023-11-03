package com.example.note_app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
fun showNote(list: MutableList<Objekt>, navController: NavController) {

    Column {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .background(color = Color.DarkGray)
                .fillMaxWidth()
        ) {
            Button(onClick = { navController.navigateUp() }) {
                Text(text = "Back")
            }


        }
        LazyColumn {
            items(list) { ThisObject ->
                Row {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .background(Color.LightGray)
                    ) {

                        Column {
                            Row {
                                Text(text = "Title: ")
                                Text(
                                    text = ThisObject.title,
                                    style = TextStyle(color = Color.White),
                                    modifier = Modifier
                                        .background(
                                            Color.Black
                                        )
                                        .fillMaxSize()
                                )
                            }
                            Row {
                                Text(text = "Note: ")
                                Text(
                                    text = ThisObject.text,
                                    style = TextStyle(color = Color.White),
                                    modifier = Modifier
                                        .background(
                                            Color.Black
                                        )
                                        .fillMaxSize()
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}




