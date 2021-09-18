package com.comye1.instagramui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            name = "philipplackner_official",
            modifier = Modifier.padding(10.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
    }
}

@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
    //밖에서 호출할 때 원하는 modifier를 설정하기 위함입니다!
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
        // 전달받은 modifier에 연결하여 사용합니다.
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            //텍스트가 최대 너비를 벗어나면 뒤에는 생략되고 ...이 붙게됩니다
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
            // sp는 사용자가 설정해놓은 폰트사이즈 기준으로 크기가 정해집니다!
        )
        Icon(
            imageVector = Icons.Outlined.Notifications,
            contentDescription = "notification",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "more",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview
@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.jiwoo),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            // weight는 Row나 Column 내 요소들에 설정할 수 있는데
            // weight를 지정한 요소들 사이에서
            // Row에서는 너비를, Column에서는 높이를
            // weight 값의 비율대로 차지하게 됩니다.
            // 그래서 ProfileSection에서는 Spacer가 16dp 너비를 차지한 뒤
            // 남은 부분을 RoundImage와 StatSection이 7:3의 비율로 차지!!
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))
        }
    }
}

@Composable
fun RoundImage(
    image: Painter, // 이미지를 호출할 때 지정해줌!
    modifier: Modifier = Modifier
    // 이미지의 사이즈를 호출할 때 지정
    // -> 이러면 여러 사이즈의 동그란 이미지를 넣을 때 재사용이 가능하겠죠??!
    // 실제로 인스타에서 스토리나 하이라이트에 사용되니까!!
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(ratio = 1f, matchHeightConstraintsFirst = true)
            // 높이를 먼저 맞추고 ratio의 비율로 너비를 맞춤 (false일 경우 너비부터)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp) // 회색 테두리 내에 하얀 띠가 생기겠죠?? 그 안에 사진
            .clip(CircleShape)
    )
}

@Composable
fun StatSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,//모든 간격이 동일
        modifier = modifier
    ) {
        ProfileStats(numberText = "601", text = "Posts")
        ProfileStats(numberText = "100K", text = "Followers")
        ProfileStats(numberText = "72", text = "Following")
    }
}

@Composable
fun ProfileStats(
    // Posts, Follwers, Following이 똑같은 형태니까 재사용
    numberText: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }
}

@Composable
fun ProfileDescription() {

}