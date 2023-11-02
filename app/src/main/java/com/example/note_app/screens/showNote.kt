package com.example.note_app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun showNote(mutableList: MutableList<Objekt>, navController: NavController) {
    var selectText by remember { mutableStateOf<Objekt?>(null) }
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

        //LazyColumn {



        if (selectText != null) {
            Column {
                Text(text = "Title: ${selectText?.title}")
                Text(text = "Text: ${selectText?.text}")
            }
            LazyColumn{
                items(mutableList){tObjekt ->
                    Row (modifier = Modifier
                        .clickable {
                            selectText =tObjekt
                            navController.navigate("showNote")
                        }){
                        Text(text = tObjekt.title)

                    }

                }


            }
        }
    }
}