package com.example.navigationforbiginners.Travel.ui.features

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun SplashScreen(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Red))
}

@Preview
@Composable
fun SplashPreview() {

}