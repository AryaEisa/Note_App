package com.example.note_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Screen(){
    var Title by rememberSaveable { mutableStateOf("") }
    var text by rememberSaveable { mutableStateOf("") }
    var SavedText by rememberSaveable { mutableStateOf("") }
    var SavedTitle by rememberSaveable { mutableStateOf("") }
    var SavedTextVisible by rememberSaveable { mutableStateOf(false) }
    var savedTitleVisible by rememberSaveable { mutableStateOf(false) }
    Row (modifier = Modifier.padding(16.dp)){
        Column() {
            Text(text = "Title")
            TextField(value = Title, onValueChange = {Title=it})
            Text(text = "Text")
            TextField(value = text, onValueChange ={text=it} )
            Button(
                onClick = {
                    SavedText = text
                    SavedTitle = Title
                    Title=""
                    text=""
                    SavedTextVisible=true
                    savedTitleVisible=true
                })
            {
                Text(text = "Save")
            }
        }

    }
}