package com.example.practices

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun LoginScreenPreview(){
    Column(modifier = Modifier.fillMaxSize()) {
        LoginScreen()
    }
}

@Composable
fun LoginScreen(){
    Column(
        modifier = Modifier
        .background(color = colorResource(id = R.color.white))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.5f)
                .clip(shape = RoundedCornerShape(bottomEnd = 100.dp))
                .background(colorResource(id = R.color.grey))
        ) {
            Image(
                painterResource(id = R.drawable.yoga_bg),
                contentDescription = "Top Login Image",
                modifier = Modifier
                    .fillMaxHeight(0.6f)
                    .fillMaxWidth()
                    .align(Alignment.Center)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(colorResource(id = R.color.grey))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .clip(shape = RoundedCornerShape(topStart = 100.dp))
                    .background(colorResource(id = R.color.white))
            ) {

                Column()
                {
                    Text(
                        text = "Please Login in",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        textAlign = TextAlign.Center,
                        style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    )
                    OutlinedTextField(
                        value = "",
                        onValueChange = { /*TODO*/},
                        label = {Text("Email")},
                        trailingIcon = {Icon(Icons.Default.Email, "")},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    )
                    OutlinedTextField(
                        value = "",
                        onValueChange = { /*TODO*/},
                        trailingIcon = {Icon(Icons.Default.Lock, contentDescription = "")},
                        label = {Text("Password")},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    )
                    Text(
                        text = "forgot password?",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp),
                        textAlign = TextAlign.Center,
                        style = TextStyle(fontSize = 14.sp, fontStyle = FontStyle.Italic)
                    )
                    Button(
                        modifier = Modifier
                            .padding(14.dp)
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(20.dp)),
                        onClick = {}) {
                        Text("Login")
                    }
                }
            }
        }

    }
}