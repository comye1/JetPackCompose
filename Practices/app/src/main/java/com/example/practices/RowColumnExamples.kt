package com.example.practices

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practices.ui.theme.PracticesTheme

@Composable
fun RowExample(){
    Row(
        horizontalArrangement = Arrangement.Center
    ){
        for(i in 1..10)
            RowElement()
    }
}

@Composable
fun RowElement(){
    Row(
        modifier = Modifier
            .padding(10.dp)
            .background(color = Color.LightGray)){
        Icon(imageVector = Icons.Default.Person, contentDescription = "ah")
        Text("Hello")
    }
}

@Composable
fun ColumnExample() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ColumnElement()
        ColumnElement()
        ColumnElement()
    }
}

@Composable
fun ColumnElement(){
    Row(
        modifier = Modifier
            .padding(10.dp)
            .background(color = Color.Yellow)){
        Icon(imageVector = Icons.Default.Person, contentDescription = "ah")
        Text("Hello")
    }
}

@Preview
@Composable
fun Preview(){
    PracticesTheme {
        Column() {
            RowExample()
            ColumnExample()
        }
    }
}