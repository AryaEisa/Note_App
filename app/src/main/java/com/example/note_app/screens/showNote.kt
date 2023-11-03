package com.example.note_app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun showNote(navController: NavController, mutableList: MutableList<Objekt>) {
var selectText by remember { mutableStateOf<Objekt?>(null) }
    Column {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .background(color = Color.DarkGray)
                .fillMaxWidth()
        ) {
            Button(onClick = { navController.navigate(Screen.Detail.route) }) {
                Text(text = "Back")
            }
        }
        if (selectText !=null){
            Column {
                Text(
                    text = "Title: ${selectText?.title}",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )
                Text(text = selectText?.text?: "")

            }
            Row {
                Button(onClick = {
                    navController.navigate(Screen.showNote.route )})
                {
                    Text(text = "List")
                }
            }
        }

        else{

                LazyColumn(
                    modifier = Modifier
                        .padding(16.dp)
                        .background(color = Color.DarkGray)
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    items(mutableList) { tObjekt ->
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                                .background(color = Color.Black)
                                .fillMaxWidth()
                        ) {
                            Row {
                                Text(text = "Title:", style = TextStyle(color = Color.White))
                                Text(text = tObjekt.title, style = TextStyle(color = Color.White))
                            }
                            Row {
                                Text(text = "Note:", style = TextStyle(color = Color.White))
                                Text(text = tObjekt.text, style = TextStyle(color = Color.White))
                            }

                            Row {
                                Button(onClick = {
                                    selectText = tObjekt
                                }) {
                                    Text(text = "Read")
                                }
                            }
                        }
                    }
                }
        }
    }
}






