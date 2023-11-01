package com.example.note_app

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp


class Objekt(val title: String, val text: String)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(list: MutableList<Objekt>, modifier: Modifier=Modifier){

    Column {
        List( list = list)
        ListView(list = list)

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun List(list: MutableList<Objekt>) {

    var title by rememberSaveable { mutableStateOf("") }
    var text by rememberSaveable { mutableStateOf("") }
    Column (modifier = Modifier
        .padding(3.dp)
        ){
        Column {
            TextField(value = title, onValueChange = { NewTitle ->
                title=NewTitle
            }, label = { Text(text = "Tiltle: ")}
            )
            TextField(value = text, onValueChange = { NewText ->
                text=NewText
            }, label = { Text(text = "Text: ")}
            )

            Button(onClick = {
                list.add(Objekt(title=title, text=text))
                println(list)
                title=""
                text=""
            }) {
                Text(text = "Save")
            }
        }
        }

}

