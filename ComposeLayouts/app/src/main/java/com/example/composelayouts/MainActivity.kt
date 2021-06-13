package com.example.composelayouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Agriculture
import androidx.compose.material.icons.outlined.Cake
import androidx.compose.material.icons.outlined.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composelayouts.ui.theme.ComposeLayoutsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLayoutsTheme {
                LazyList()
            }
        }
    }
}

@Composable
fun LazyList(){
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState) {
        items(100) {
            Text("Item #$it")
        }
    }
}

@Preview(name = "LazyListPreview")
@Composable
fun LazyListPreview(){
    ComposeLayoutsTheme {
        LazyList()
    }
}
@Composable
fun SimpleList(){

    val scrollState = rememberScrollState()

    Column(Modifier.verticalScroll(scrollState)){
        repeat(100){
            Text("Item $it")
        }
    }
}

@Preview(name = "ListPreview")
@Composable
fun ListPreview(){
    ComposeLayoutsTheme {
        SimpleList()
    }
}

@Composable
fun PhotographerCard(modifier: Modifier = Modifier){
    Row(
        modifier
//        .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(MaterialTheme.colors.surface)
            .clickable(onClick = {/**/ })
            .padding(16.dp)) {
        Surface(
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {

        }
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ){
            Text("Alfred Sisley", fontWeight = FontWeight.Bold)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text("3 minutes ago", style = MaterialTheme.typography.body2)
            }
        }
    }

}

@Preview
@Composable
fun PhotographerCardPreview() {
    ComposeLayoutsTheme{
        PhotographerCard()
    }
}

@Composable
fun LayoutsCodelab(){
    Scaffold(
        topBar = {
            TopAppBar (
                title = {
                    Text(text = "LayoutsCodelab")
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Outlined.Cake, contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
        BodyContent(
            Modifier
                .padding(innerPadding)
                .padding(8.dp))
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Hi there!")
        Text(text = "Thanks for going through the Layouts codelab")
    }
}

//@Preview(name = "layoutsCodelabPreview")
@Composable
fun LayoutsCodelabPreview(){
    ComposeLayoutsTheme {
        LayoutsCodelab()
    }
}