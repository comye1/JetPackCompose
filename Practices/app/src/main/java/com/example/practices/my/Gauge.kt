package com.example.practices.my

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GaugeBar(levelGuage: Float) {
    Box {
        Surface(
            modifier = Modifier
                .fillMaxWidth(.5f)
                .height(20.dp),
            color = Color.LightGray
        ) {}
        Surface(
            modifier = Modifier
                .fillMaxWidth(levelGuage * (0.5f))
                .height(20.dp)
                .background(color = Color.Magenta),
            color = Color.Magenta
        ) {
        }
    }
}

@Preview
@Composable
fun GaugeBarPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        GaugeBar(levelGuage = 0.5f)
        GaugeBar(levelGuage = 0.2f)
        GaugeBar(levelGuage = 0.82f)
    }
}