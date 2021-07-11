package com.example.practices.my

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practices.R

data class BaseballTeam(
    val name: String,
    val image: Int
)

val baseballTeams = listOf(
    BaseballTeam("Kiwoom Heroes", R.drawable.emblemwo),
    BaseballTeam("Hanwha Eagles", R.drawable.emblemhh),
    BaseballTeam("Samsung Lions", R.drawable.emblemss),
    BaseballTeam("Kia Tigers", R.drawable.emblemht),
    BaseballTeam("LG Tweens", R.drawable.emblemlg),
    BaseballTeam("Doosan Bears", R.drawable.emblemob),
    BaseballTeam("Lotte Giants", R.drawable.emblemlt),
    BaseballTeam("NC Dinos", R.drawable.emblemnc),
    BaseballTeam("SSG Landers", R.drawable.emblemsk),
    BaseballTeam("KT Wiz", R.drawable.emblemkt)
)

@ExperimentalMaterialApi
@Preview
@Composable
fun SelectionScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.LightGray)
        .padding(16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var selectedTeam by remember {
            mutableStateOf("")
        }

        Text("Select Your Team", style = MaterialTheme.typography.h4)

        Spacer(modifier = Modifier.height(30.dp))
        LazyColumn (modifier = Modifier.weight(1f)){
            item {

                for(t in baseballTeams){
                    TeamCard(team = t, selected = selectedTeam == t.name) {
                        selectedTeam = t.name
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { /*TODO*/ }) {
            Text("Selected : ${selectedTeam}")
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun TeamCard(
    team: BaseballTeam,
    selected: Boolean,
    onClick: () -> Unit
) {
    Column(modifier = Modifier.padding(bottom = 10.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            backgroundColor = if (selected) Color.Yellow else Color.White,
            onClick = onClick
        ) {
            Row(modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painterResource(id = team.image), contentDescription = team.name,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .padding(end = 10.dp)
                )
                Text(text = team.name, style = MaterialTheme.typography.h5)
            }
        }
    }

}