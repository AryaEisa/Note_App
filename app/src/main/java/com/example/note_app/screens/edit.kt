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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun edit(list: MutableList<Objekt>, navController: NavController) {
    Column {
        Row {
            Button(onClick = { navController.navigateUp()}) {
                Text(text = "Back")
            }
        }
        LazyColumn {
            items(list) { thisObject ->
                var isEditingText by remember { mutableStateOf(false) }
                var isEditingTitle by remember { mutableStateOf(false) }
                var updateText by remember { mutableStateOf(thisObject.text) }
                var updateTitle by remember { mutableStateOf(thisObject.title) }
                Row {
                    Column(modifier = Modifier.padding(40.dp)) {
                        Column {
                            Row {
                                   if (isEditingText){
                                       TextField(value = updateText, onValueChange = {updateText= it })

                                   }else {
                                       Text(text = updateText)
                                   }
                                if (isEditingTitle){
                                    TextField(value = updateTitle, onValueChange ={updateTitle=it} )
                                }else {
                                    Text(text = updateTitle)
                                }
                                Button(onClick = { isEditingText=!isEditingText}.also { isEditingTitle=!isEditingTitle }) {
                                    Text(text = if (isEditingText && isEditingTitle)  "Save" else "Edit")
                                    list.add(Objekt(text = updateText, title = updateTitle))
                                    println(list)
                                    updateTitle=""
                                    updateText=""
                                    
                                }
                                }

                            }


                            }

                        }
                    }

                }

            }
        }


