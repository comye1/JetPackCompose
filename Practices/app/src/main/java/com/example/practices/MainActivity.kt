package com.example.practices

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practices.ui.theme.PracticesTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticesTheme {
                Column (modifier = Modifier
                    .fillMaxSize()
                    .background(Color.LightGray)
                    .padding(24.dp)
                ) {
                  ExpandableCard()
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun DefaultPreview() {
    PracticesTheme {
        Column (modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(24.dp)
        ) {
            ExpandableCard()
        }
    }
}
