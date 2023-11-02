package com.example.note_app.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun showNote(mutableList: MutableList<Objekt>, navController: NavController) {
    Row(modifier = Modifier.padding(16.dp)) {
        Button(onClick = { navController.navigate(Screen.Home.route) }) {
            Text(text = "Back")
        }
    }
    LazyColumn {
        items(mutableList) { tObjekt ->
            Column {
                Text(text = tObjekt.title)
                Text(text = tObjekt.text)
            }
        }
    }
}