package com.example.practices

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview(showBackground = true)
@Composable
fun PlantHomeScreen() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        val (topBar, logoBar, searchBar, topSlide, bottomSlide, bottomBar) = createRefs()

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.25f)
                .clip(shape = RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp))
                .constrainAs(topBar) {
                    top.linkTo(parent.top)
                }, color = colorResource(id = R.color.greenColor)
        ) {

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(logoBar) {
                    centerTo(topBar)
                }
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("PlantShopy", style = TextStyle(color = Color.White, fontSize = 30.sp))

            Image(
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp),
                painter = painterResource(id = R.drawable.puppy),
                contentDescription = ""
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
                .height(48.dp)
                .constrainAs(searchBar) {
                    top.linkTo(topBar.bottom, margin = (-24).dp)
                    centerHorizontallyTo(parent)
                }
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(20.dp)
                )
                .clip(shape = RoundedCornerShape(20.dp))
                .background(color = Color.White)
                .padding(horizontal = 20.dp), contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text("Search")
                Icon(Icons.Outlined.Search, contentDescription = "", tint = Color.Black)
            }
        }
        Column(
            modifier = Modifier
                .padding(20.dp)
                .constrainAs(topSlide) {
                    top.linkTo(searchBar.bottom, margin = (-10).dp)
                }
        ) {
          Row(
              modifier = Modifier
                  .fillMaxWidth()
                  .padding(vertical = 8.dp),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween
          ) {
              Text("Recommended Plants ", style = TextStyle(fontSize = 18.sp))

              Text(
                  "more",
                  style = TextStyle(
                      fontSize = 16.sp,
                      color = colorResource(id = R.color.greenColor)
                  )
              )
          }

            LazyRow(content = {
                item {
                    itemCard(width = 180.dp, image = R.drawable.image_1, name = "Samarthi")
                    itemCard(width = 180.dp, image = R.drawable.image_2, name = "Neem")
                    itemCard(width = 180.dp, image = R.drawable.image_3, name = "Peeppali")
                }
            })
        }

        Column(
            modifier = Modifier
                .padding(20.dp)
                .constrainAs(bottomSlide) {
                    top.linkTo(topSlide.bottom, margin = (-10).dp)
                }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Featured Plants ", style = TextStyle(fontSize = 18.sp))

                Text(
                    "more",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.greenColor)
                    )
                )
            }

            LazyRow(content = {
                item {
                    itemCard(width = 260.dp, image = R.drawable.image_1, name = "Samarthi")
                    itemCard(width = 260.dp, image = R.drawable.image_2, name = "Neem")
                }
            })
        }

        BottomNavigation(modifier = Modifier
            .constrainAs(bottomBar) {
                bottom.linkTo(parent.bottom)
            }
            .clip(
                shape = RoundedCornerShape(
                    topStart = 10.dp,
                    topEnd = 10.dp
                )
            ),
            backgroundColor = colorResource(id = R.color.greenColor)
        ) {
            BottomNavigationItem(selected = true, onClick = { /*TODO*/ },
                icon = { Icon(Icons.Filled.Home, contentDescription = "", tint = Color.White) }, label = {
                    Text(text = "Home")
                })
            BottomNavigationItem(selected = false, onClick = { /*TODO*/ },
                icon = { Icon(Icons.Filled.Favorite, contentDescription = "", tint = Color.White) }, label = {
                    Text(text = "Favorite")
                })
        }
    }
}


@Composable
fun itemCard(width: Dp, image: Int, name: String)
{
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .height(200.dp)
            .width(width)
    ){
        Column() {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                painter = painterResource(id = image), contentDescription = "")

            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(name, style = TextStyle(fontSize = 16.sp, color = Color.Black))
                Text("Rs 200", style = TextStyle(color = colorResource(id = R.color.greenColor)))
            }
        }
    }
}