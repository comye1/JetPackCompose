package com.example.practices

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.practices.ui.theme.Shapes
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@ExperimentalMaterialApi
@Composable
fun ExpandableCard(
    title: String,
    titleFontSize: TextUnit = MaterialTheme.typography.h6.fontSize,
    titleFontWeight: FontWeight = FontWeight.Bold,
    description: String,
    descriptionFontSize: TextUnit = MaterialTheme.typography.subtitle1.fontSize,
    descriptionFontWeight: FontWeight = FontWeight.Normal,
    descriptionMaxLines: Int = 4,
    shape: CornerBasedShape = Shapes.medium,
    padding: Dp = 12.dp,

    ){
    var expandedState by remember {
        mutableStateOf(false)
    }
    val rotationState by animateFloatAsState(
        targetValue = if(expandedState) 180f else 0f
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
            .padding(padding),
        shape = shape,
        onClick = {
            expandedState = !expandedState
        }
    ){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ){

            Row(verticalAlignment = Alignment.CenterVertically){
                Text(
                    modifier = Modifier
                        .weight(6f),
                    text = title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = titleFontSize,
                    fontWeight = titleFontWeight
                )
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .weight(1f)
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop Down Arrow"
                    )
                }
            }
            if(expandedState) {
                Text(
                    text = description,
//                    "It is a long established fact that a reader will be distracted " +
//                            "by the readable content of a page when looking at its layout. " +
//                            "The point of using Lorem Ipsum is that it has a more-or-less " +
//                            "normal distribution of letters, as opposed to using 'Content here, " +
//                            "content here', making it look like readable English. ",
                    fontSize = descriptionFontSize,
                    fontWeight = descriptionFontWeight,
                    maxLines = descriptionMaxLines,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
fun ExpandableCardPreview() {
    ExpandableCard(
        title = "Title",
        description = "It is a long established fact that a reader will be distracted " +
                "by the readable content of a page when looking at its layout. " +
                "The point of using Lorem Ipsum is that it has a more-or-less " +
                "normal distribution of letters, as opposed to using 'Content here, " +
                "content here', making it look like readable English. ",

    )
}