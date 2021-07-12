package com.example.practices.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun TextFieldsPreview() {
    PracticesTheme {
        TextFields()
    }
}

@Composable
fun TextFields() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var text by remember {
            mutableStateOf("Type here...")
        }
        TextField(
            value = text, onValueChange = { newText ->
                text = newText
            },
//            enabled = false,
//            readOnly = true,
        label = {
            Text(text = "Title")
        },
//        singleLine = true,
        maxLines = 2
        )
    }
}