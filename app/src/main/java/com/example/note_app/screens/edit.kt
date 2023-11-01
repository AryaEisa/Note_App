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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun edit(list: MutableList<Objekt>, navController: NavController) {
    var text by rememberSaveable { mutableStateOf("") }
    var title by rememberSaveable { mutableStateOf("") }
    var Edittext by rememberSaveable { mutableStateOf(false) }
    var Edittitle by rememberSaveable { mutableStateOf(false) }
    Column {
        Row {
            Button(onClick = { navController.navigateUp()}) {
                Text(text = "Back")
            }
        }
        LazyColumn {
            items(list) { thisObject ->
                Row {
                    Column(modifier = Modifier.padding(40.dp)) {
                        Column {
                            Row {
                                    Button(onClick = {
                                        Edittext
                                    }) {
                                        Text(text = "Edit")
                                    }
                                }

                            }
                            Row {

                            }

                        }
                    }

                }

            }
        }
    }

