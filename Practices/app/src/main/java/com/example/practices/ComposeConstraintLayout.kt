package com.example.practices

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.practices.ui.theme.PracticesTheme

@ExperimentalMaterialApi
@Composable
fun ConstraintExample() {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (card,topImage,addButton,text,thumbIcon)= createRefs()


        Card(modifier = Modifier
            .constrainAs(card) {
                centerTo(parent)
            }
            .fillMaxWidth(.9f)
            .fillMaxHeight(.4f)
        ){



        }

        Surface(modifier = Modifier
            .constrainAs(topImage) {
                top.linkTo(card.top)
                start.linkTo(card.start)
            }
            .fillMaxWidth(.9f)
            .fillMaxHeight(.2f),
            color = Color.Yellow
        ) {}


        FloatingActionButton(
            modifier = Modifier
                .constrainAs(addButton){
                    top.linkTo(topImage.bottom, margin = (-20).dp)
                    end.linkTo(topImage.end, margin = 10.dp)
                },
            backgroundColor = Color.Black,
            onClick = {

            }) {

            Icon(Icons.Default.Add,contentDescription = "",tint = Color.Yellow)
        }

        Text(
            text = "Welcome to Jetpack Compose",
            style = TextStyle(color = Color.Black, fontSize = 24.sp),
            modifier = Modifier.constrainAs(text) {
                centerHorizontallyTo(card)
                top.linkTo(addButton.bottom)
            }
        )

        Icon(
            Icons.Outlined.ThumbUp, contentDescription = "", tint = Color.Black,
            modifier = Modifier
                .constrainAs(thumbIcon) {
                    centerTo(topImage)
                }
                .height(50.dp)
                .width(50.dp)
        )

    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun ConstraintExamplePreview() {
    PracticesTheme {
        ConstraintExample()
    }
}