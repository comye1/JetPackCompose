package com.example.practices

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout


@ExperimentalComposeUiApi
@Preview
@Composable
fun ShopHomeScreen(){

    val shoeList  = listOf(
        Shoe("499",R.color.lightPink,R.drawable.shoe1),
        Shoe("899",R.color.lightBlue,R.drawable.shoe2),
        Shoe("999",R.color.lightIndigo,R.drawable.shoe3)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.backgroundBlue))
            .padding(horizontal = 20.dp, vertical = 8.dp)
    ) {
        IconButton(
            onClick = {  }
        ) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = "",
                tint = Color.Black
            )
        }
        BuildSpacer()
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Cool Design",
            style = TextStyle(color = Color.Black, fontSize = 30.sp, fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Center
        )
        BuildSpacer()
        Text(
            text = "Lit of all imported design shoes",
            style = TextStyle(fontSize = 14.sp, color = Color.Black)
        )
        BuildSpacer()

        for(shoe in shoeList){
            BuildSingleShoeCard(shoe = shoe)
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun BuildSingleShoeCard(shoe: Shoe) {

    ConstraintLayout(
        Modifier
            .fillMaxWidth()
            .height(230.dp)
    ) {

        val (addButton, bgImage, shoeImage, priceTag) = createRefs()

        Surface(
            modifier = Modifier
                .fillMaxWidth(.5f)
                .fillMaxHeight()
                .clip(shape = RoundedCornerShape(20.dp))
                .constrainAs(bgImage) {
                    start.linkTo(parent.start, margin = 8.dp)
                }, color = colorResource(id = shoe.color)
        ){

        }

        Box(
            modifier = Modifier
                .height(46.dp)
                .width(46.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .background(color = Color.White)
                .constrainAs(addButton) {
                    top.linkTo(parent.top)
                },
            contentAlignment = Alignment.Center
        ){
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = ""
            )
        }

        Image(
            modifier = Modifier
                .fillMaxWidth(.6f)
                .constrainAs(shoeImage) {
                    centerVerticallyTo(parent)
                    start.linkTo(parent.start, margin = 30.dp)
                }
                .rotate(-25f),
            painter = painterResource(id = shoe.image), contentDescription = ""
        )

        Text(
            modifier = Modifier
                .constrainAs(priceTag){
                     end.linkTo(parent.end, margin = 30.dp)
                    bottom.linkTo(parent.bottom, margin = 20.dp)
            },
            text = shoe.price,
            style = TextStyle(color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        )

    }
}

data class Shoe(val price: String, val color: Int, val image: Int)

@Composable
fun BuildSpacer()
{
    Spacer(modifier = Modifier.height(10.dp))
}