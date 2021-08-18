package com.example.practices.my

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimationGaugeBars() {
    Column(modifier = Modifier.padding(8.dp)) {
        AnimationGaugeBar(value = 80, color = Color.Red)
        Spacer(modifier = Modifier.height(8.dp))
        AnimationGaugeBar(value = 25, color = Color.Yellow)
    }
}

@Composable
fun AnimationGaugeBar(
    value: Int,
    color: Color
) {
    var animationPlayed by remember{
        mutableStateOf(false)
    }
    val curValue = animateIntAsState(
        targetValue = if(animationPlayed) value else 0,
        animationSpec = tween(
            durationMillis = 2000,
            delayMillis = 0
        )
    )
    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .clip(CircleShape)
            .background(Color.LightGray)

    ){
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(curValue.value / 100f)
                .clip(CircleShape)
                .background(color = color)
                .padding(8.dp)
        ){
            Text(text = curValue.value.toString())
        }
    }
}