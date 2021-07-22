package com.example.navigationforbiginners

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationforbiginners.Travel.ui.features.SplashScreen
import com.example.navigationforbiginners.ui.theme.NavigationForBiginnersTheme
import com.google.accompanist.insets.ProvideWindowInsets

@Preview
@Composable
fun TravelAppPreview() {
    NavigationForBiginnersTheme {


        TravelApp()

    }
}

@Composable
fun TravelApp() {
    val navController = rememberNavController()

    ProvideWindowInsets {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            NavHost(
                navController = navController,
                startDestination = "splash"
            ) {
                composable("splash"){
                    SplashScreen(navController)
                }
            }
        }

    }

}