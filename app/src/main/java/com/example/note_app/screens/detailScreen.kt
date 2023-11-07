package com.example.note_app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun detailScreen(list: MutableList<Objekt>, modifier: Modifier = Modifier, navController: NavController) {

    Column {
        List( list = list, navController=navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun List(list: MutableList<Objekt>, navController: NavController) {
    Row (
        modifier = Modifier
            .background(color = Color.Black)
            .fillMaxWidth()
    ){
        Button(onClick = { navController.navigateUp() }) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "close" )

        }
    }

    var title by rememberSaveable { mutableStateOf("") }
    var text by rememberSaveable { mutableStateOf("") }
    Column {
        Column (modifier = Modifier
            .background(androidx.compose.ui.graphics.Color.Gray)
            .fillMaxSize()){
            TextField(value = title, onValueChange = { NewTitle ->

                        title=NewTitle

                
            }, label = { Text(text = "Tiltle: ") }
            )
            TextField(value = text, onValueChange = { NewText ->
                text=NewText
            }, label = { Text(text = "Text: ") }
            )
            if (title.length >= 3 && text.length <= 120){
                if (title.length<=50){
                    Row {
                        Button(onClick = {
                            list.add(Objekt(title=title, text =text))
                            println(list)
                            title=""
                            text=""
                        }) {
                            Icon(imageVector = Icons.Default.Check, contentDescription = null)
                        }

                    }
                }
                else {
                    Text(text = "Sorry, your title can't be bigger then 50 characters")
                }

            }
            else{
                null
            }
            Row {
                Button(onClick = {
                    navController.navigate(Screen.Detail.route)
                }) {
                    Icon(imageVector = Icons.Default.List, contentDescription = "List")
                }
            }
            Column (modifier = Modifier
                .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text = "The title have to contain at least 3 characters\n" +
                        "The title have to contain at most 50 characters\n" +
                        "The text have to contain at most 120 characters",
                    style = TextStyle(color = Color.Black,
                    fontWeight= FontWeight.ExtraBold,
                    fontSize = 18.sp
                ),
                    textAlign = TextAlign.Center
                )

            }


        }
    }

}

