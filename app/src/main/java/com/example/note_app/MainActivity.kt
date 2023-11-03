package com.example.note_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.note_app.screens.Objekt
import com.example.note_app.screens.headScreen
import com.example.note_app.ui.theme.Note_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val showBackButton= rememberSaveable { mutableStateOf(false) }
            val navController = rememberNavController()
            val list = remember { mutableStateListOf<Objekt>()}

            Note_AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                   headScreen()
                   }
                    
                //MainScreen(list = list)
                }
            }
        }
    }




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
 Note_AppTheme {
        headScreen()

 }

}