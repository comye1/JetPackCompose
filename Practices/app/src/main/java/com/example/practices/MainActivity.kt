package com.example.practices

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import com.example.practices.ui.theme.PracticesTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticesTheme {
                Surface(color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}
