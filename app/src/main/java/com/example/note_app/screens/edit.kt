package com.example.note_app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun edit( navController: NavController, mutableList: MutableList<Objekt>) {

    Column {
        Row (modifier = Modifier

            .background(color = Color.DarkGray)
            .fillMaxWidth()
            .padding(16.dp)
        ){
            Button(onClick = { navController.navigateUp() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
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
                            onValueChange = { editText = it },
                            maxLines = 10,
                            label = { Text(text = "Note: ") }
                        )
                if (editTitle.length > 3 && editText.length < 120){
                    if (editTitle.length<50){
                        Button(
                            onClick = {
                                selectText?.let { Tobjekt ->
                                    Tobjekt.title = editTitle
                                    Tobjekt.text = editText
                                }
                                editTitle=""
                                editText=""
                                selectText=null
                            }) {
                            Icon(imageVector = Icons.Default.Check, contentDescription = null)
                        }
                    }else {
                        Text(text = "Sorry, your title can't be bigger then 50 characters")
                    }
                }else{
                    Text(text = "Sorry your title has to be larger then 3 characters and your note can't be larger then 120 characters")
                }

                }
            }


        else {
        LazyColumn(modifier = Modifier
            .padding(16.dp)
            .background(color = Color.DarkGray)
            .fillMaxWidth()
            .fillMaxHeight()){
            items(mutableList){
                tObjekt ->
                Column(modifier = Modifier
                    .padding(16.dp)
                    .background(color = Color.Black)
                    .fillMaxWidth()) {
                    Row {
                        Text(text = "Title: ", style = TextStyle(color = Color.White))
                        Text(text = tObjekt.title, style = TextStyle(color = Color.White))
                    }
                    Row {
                        Text(text = "Note: ", style = TextStyle(color = Color.White))
                        Text(text = tObjekt.text,  style = TextStyle(color = Color.White))
                    }

                }
                Row {
                    Button(
                        onClick = {
                            selectText = tObjekt
                            editTitle = tObjekt.title
                            editText = tObjekt.text
                        }) {
                        Icon(imageVector = Icons.Default.Create, contentDescription = null)
                    }

                }

            }
        }

        }
    }
}



