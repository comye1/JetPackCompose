package com.example.practices.ui.theme

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
//        TextField(
        OutlinedTextField(
            value = text, onValueChange = { newText ->
                text = newText
            },
//            enabled = false,
//            readOnly = true,
            label = {
                Text(text = "Title")
            },
//        singleLine = true,
//        maxLines = 2
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "Email icon"
                    )
                }
            },
            trailingIcon = {
                IconButton(onClick = { Log.d("Trailing Icon", "Clicked") }) {
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = "Check Icon"
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    Log.d("ImeAction", "Clicked")
                }
            )
        )

        Spacer(modifier = Modifier.height(16.dp))
        BasicTextField(
            modifier = Modifier
                .background(Color.Magenta)
                .padding(16.dp),
            value = text,
            onValueChange = { newText ->
                text = newText
            }
        )
    }
}