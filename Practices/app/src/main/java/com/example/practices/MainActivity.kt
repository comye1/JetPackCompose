package com.example.practices

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.practices.my.SelectionScreen

class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SelectionScreen()
//            PlantHomeScreen()
//            ConstraintExample()
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

