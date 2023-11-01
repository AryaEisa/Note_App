package com.example.note_app.screens

sealed class Screen(val route: String){
    object Home: Screen(route = "home")
    object Detail: Screen(route = "detail")

    object Edit: Screen(route = "Edit")
}
