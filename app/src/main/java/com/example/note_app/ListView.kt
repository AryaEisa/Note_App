package com.example.note_app

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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

@Composable
fun ListView(list: MutableList<Objekt>) {
    LazyColumn(modifier = Modifier
        .background(color = Color.Black)
        .fillMaxSize()){
        items(list){ThisObject ->
            Column (modifier = Modifier.padding(40.dp)){
                Row {
                    Text(text = ThisObject.title, style = TextStyle(color = Color.White) )
                    Text(text = ThisObject.text, style = TextStyle(color = Color.White) )
                    Button(onClick = {list.remove(ThisObject)}) {
                        Text(text = "Delete")
                    }
                }

            }




        }
    }

}