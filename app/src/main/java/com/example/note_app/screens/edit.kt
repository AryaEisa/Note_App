package com.example.note_app.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.util.UUID

@Composable
fun edit(mutableList: MutableList<Objekt>, navController: NavController) {

    Column {
        Row {
            Button(onClick = { navController.navigateUp() }) {
                Text(text = "Back")
            }
        }

        //LazyColumn {

                var selectText by remember { mutableStateOf<Objekt?>(null) }
                var editTitle by remember { mutableStateOf("") }
                var editText by remember { mutableStateOf("") }
        if (selectText !=null) {
            Column {
                TextField(
                    value = editTitle,
                    onValueChange = {editTitle = it},
                    maxLines = 4,
                    label = { Text(text = "Title: ")}
                )
                TextField(
                    value = editText,
                    onValueChange = {editText = it},
                    maxLines = 10,
                    label = { Text(text = "Note: ")}
                )
                Button(
                    onClick = {
                        selectText?.let { Tobjekt ->
                            Tobjekt.title = editTitle
                            Tobjekt.text =editText
                        }
                        editTitle=""
                        editText=""
                        selectText=null
                    }) {
                    Text(text = "Save")
                }
            }
        }
        else {
        LazyColumn{
            items(mutableList){
                tObjekt ->
                Column {
                    Text(text = tObjekt.title)
                    Text(text = tObjekt.text)
                }
                Button(
                    onClick = { 
                        selectText = tObjekt
                        editTitle = tObjekt.title
                        editText = tObjekt.text
                    }) {
                    Text(text = "Edit")
                }
                Button(
                    onClick = { 
                        mutableList.remove(tObjekt)
                    }) {
                    Text(text = "Delete")
                    
                }
            }
        }

        }
    }
}



