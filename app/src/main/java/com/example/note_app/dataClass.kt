package com.example.note_app

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import java.util.UUID

data class Task( //Vi definerar en kotlin-dataklass som heter Task
    val id: String = UUID.randomUUID().toString(),
    //här uppe deklarerar vi en fält med namnet id som är sträng som
    // representerar en unik ID för varje uppgift UUID.random... Tilldelar en slumpmässigt
    // Id om inget annat sägs.
    val title: String,
    var isChecked: MutableState<Boolean> = mutableStateOf(false)
)