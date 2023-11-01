package com.example.note_app

import android.graphics.Paint.Style
import android.widget.ListView
import androidx.compose.animation.VectorConverter
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import kotlin.collections.isNotEmpty



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen(){
    var Title by rememberSaveable { mutableStateOf("") }
    var text by rememberSaveable { mutableStateOf("") }
    var SavedText by rememberSaveable { mutableStateOf("") }
    var SavedTitle by rememberSaveable { mutableStateOf("") }
    var SavedTextVisible by rememberSaveable { mutableStateOf(false) }
    var savedTitleVisible by rememberSaveable { mutableStateOf(false) }
    var IsEditing by rememberSaveable { mutableStateOf(false) }
    var Editing by rememberSaveable { mutableStateOf(false) }
    var MyTitle = listOf(SavedTitle)
    var MyList = listOf(SavedText)
    var SaveButtonPressed by rememberSaveable { mutableStateOf(false) }

    Row (modifier = Modifier
        .background(Color.Red)
        .fillMaxSize()){
        Column(modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxSize()) {

            Text(text = "Title")
            TextField(value = Title, onValueChange = {Title=it})
            Text(text = "Text")
            TextField(value = text, onValueChange ={text=it} )
            Row {
                Button(
                    onClick = {
                        SavedText = text
                        SavedTitle = Title
                        Title=""
                        text=""
                        SavedTextVisible=true
                        savedTitleVisible=true
                        SaveButtonPressed=true

                    })
                {
                    Text(text = "Save")

                }

                Button(
                    onClick = {
                        text = SavedText
                        Title=SavedTitle
                    } ) {
                    Text(text = "Edit")
                }
            }
            Column(modifier = Modifier
                .background(Color.Green)
                .fillMaxSize()) {
                if (SaveButtonPressed){
                    Column {
                        Text(text = "Title: ", style = TextStyle(color= Color.Red, fontSize = 20.sp, background = (Color.Black)))
                        MyTitle.forEach { title ->
                            Text(

                                text = AnnotatedString(title),
                                style = TextStyle(color = Color.Black)
                            )
                        }
                        MyList.forEach{ item ->
                            Text(text = "Note: ", style = TextStyle(color= Color.Red, fontSize = 20.sp,  background = (Color.Black)))
                            Text(
                                text = AnnotatedString(item),
                                style = TextStyle(color = Color.Black))
                        }
                    }

                }





            }
            }



    }

}



