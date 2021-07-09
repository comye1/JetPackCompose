package com.example.practices

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practices.ui.theme.PracticesTheme

class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintExample()
//            LoginScreen()
//            PracticesTheme {
//                Box(
//                    contentAlignment = Alignment.Center,
//                    modifier = Modifier.fillMaxSize()
//                ){
//                    CircularProgressBar(percentage = 0.8f, number = 100)
//                }
//
//            }
        }
    }
}

