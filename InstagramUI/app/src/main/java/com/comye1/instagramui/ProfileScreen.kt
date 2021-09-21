package com.comye1.instagramui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.GridView
import androidx.compose.material.icons.rounded.LiveTv
import androidx.compose.material.icons.rounded.SmartDisplay
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalFoundationApi
@Preview
@Composable
fun ProfileScreen() {

    // 선택된 탭의 index를 저장
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            name = "philipplackner_official",
            modifier = Modifier.padding(10.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))
        HighligtSection(
            highlights = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.pic1),
                    text = "Youtube"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.pic4),
                    text = "Q&A"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.pic5),
                    text = "Discord"
                )
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))

        PostTabView(
            imageWithTexts = listOf(
                // 탭 아이템
                // 이미지 구하기 귀찮아서 imageVector(아이콘) -> painter 변환하는 함수 사용했습니다.
                ImageWithText(
                    image = rememberVectorPainter(image = Icons.Rounded.GridView),
                    text = "Posts"
                ),
                ImageWithText(
                    image = rememberVectorPainter(image = Icons.Rounded.SmartDisplay),
                    text = "Reels"
                ),
                ImageWithText(
                    image = rememberVectorPainter(image = Icons.Rounded.LiveTv),
                    text = "IGTV"
                ),
                ImageWithText(
                    image = rememberVectorPainter(image = Icons.Rounded.AccountBox),
                    text = "Profile"
                ),
            )
            // ,onTabSelected = { selectedTabIndex = it } 코틀린에서 마지막 argument가 함수일 때
            // 밖으로 {}를 빼내어 작성할 수 있습니다!
            // 대표적으로 Row(){}에서도 {}안의 내용이 원래는 argument 입니다
        ) {
            selectedTabIndex = it //그래서 이부분은 onTabSelected 에 해당합니다
        }
        when (selectedTabIndex) {
            0 -> PostSection( // 인덱스가 0 (Posts 탭)인 경우에만 구현을 해놓은 상태입니다.
                posts = listOf( // List<Painter>인 posts를 전달하면 그리드뷰에 표시되는 것입니다
                    painterResource(id = R.drawable.cat),
                    painterResource(id = R.drawable.dog),
                    painterResource(id = R.drawable.horse),
                    painterResource(id = R.drawable.rabbit),
                    painterResource(id = R.drawable.cat),
                    painterResource(id = R.drawable.dog),
                    painterResource(id = R.drawable.horse),
                    painterResource(id = R.drawable.rabbit),
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
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
        ProfileDescription(
            displayName = "Programming Mentor",
            description = "10 years of coding experience\n" +
                    "wnat me to make your app? Send me an email!\n" +
                    "Subscribe to my YouTube channel!",
            // \n은 줄바꿈 문자 -> Text안에 들어가면 실제로 줄바꿈됨!
            url = "https://youtube.com/c/PhilippLackner",
            followedBy = listOf("codinginflow", "miakhalifa"),
            otherCount = 17
        )
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
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing, //자간
            lineHeight = lineHeight //줄간격
        )
        Text(
            text = description,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = url,
            color = Color(0xFF3D3D91),
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        if (followedBy.isNotEmpty()) {
            // 말그대로 followedBy 리스트가 비어있지 않으면
            Text(
                text = buildAnnotatedString {
                    //부분적으로 스타일을 지정할 수 있는 String Builder라고 대충 이해
                    val boldStyle = SpanStyle( // 부분적으로 적용할 Style 정의
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")
                    followedBy.forEachIndexed { index, name ->
                        // followedBy의 모든 아이템을 순서대로 돌면서
                        // 현재의 인덱스는 index에, followedBy[index]는 name에 저장됨
                        pushStyle(boldStyle) // 이 뒤에는 push된 스타일이 적용됨
                        append(name) // name에 boldStyle이 적용되겠죠??
                        pop() // 스타일이 pop되어 이제 적용되지 않음
                        if (index < followedBy.size - 1) { // 마지막 name이 아니면 쉼표를 붙인다
                            append(", ")
                        }
                    }
                    if (otherCount > 2) { // 2명보다 많으면
                        append(" and ") // and를 붙이고
                        pushStyle(boldStyle) // 다시 boldStyle로
                        append("$otherCount others") // 17 others
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }
}

@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
) {
    val minWidth = 95.dp
    val height = 30.dp
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                // 최소너비 지정, text가 이 너비보다 길어지면 그에 맞게 길어짐
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .height(height)
        )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null, // 타입 뒤에 ?를 붙이면 해당 타입의 값과 null을 담을 수 있습니다
    icon: ImageVector? = null
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        if (text != null) { // text가 null이 아닐 때
            Text( // Text를 넣고
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        if (icon != null) { // icon이 null이 아닐 때
            Icon( // Icon을 넣는다
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}

@Composable
fun HighligtSection(
    modifier: Modifier = Modifier,
    highlights: List<ImageWithText>
) {
    LazyRow(modifier = modifier) {
        items(highlights.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(end = 15.dp)
            ) {
                RoundImage(
                    image = highlights[it].image, // it -> highlights의 index를 나타냄
                    modifier = Modifier.size(70.dp)
                )
                Text(
                    text = highlights[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithTexts: List<ImageWithText>, // 각 탭
    onTabSelected: (selectedIndex: Int) -> Unit
    // 코틀린에서 () -> () 형태는 함수의 표현입니다
    // 앞부분은 arguments와 arguments의 타입
    // 뒷부분은 반환하는 타입입니다.
    // Unit이라는 단어가 생소하실 텐데
    // C,JAVA의 void와 같이 반환하지 않는 타입입니다.
) {
    // 현재 선택된 탭의 인덱스를 저장합니다.
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)

    TabRow( // TabRow는 Tab아이템들을 포함하여 탭뷰를 생성
        selectedTabIndex = selectedTabIndex, // TabRow가 선택된 Tab을 보여줍니다!
        backgroundColor = Color.Transparent,
        contentColor = Color.Black, // 탭을 표시해주는 막대의 색깔
        modifier = modifier
    ) {
        imageWithTexts.forEachIndexed { index, item ->
            Tab(
                selected = selectedTabIndex == index,
                // 이 탭이 선택된 탭인지 알 수 있는 방법! 이해되시나요?
                // (selectedTabIndex == index)라는 표현식의 값, 즉 true 또는 false
                selectedContentColor = Color.Black, // selected가 true일 때 {} 내 요소들의 색깔
                unselectedContentColor = inactiveColor, // selected가 false일 때
                onClick = { // 클릭이 되면 자신의 index로 selectedTabIndex로 바꿔줘야 합니다!
                    selectedTabIndex = index
                    onTabSelected(index)
                    // 전달받은 onTabSelected함수도 호출해 줍니다 (호출한 쪽에서 로직을 처리합니다)
                }
            ) {
                Icon(
                    painter = item.image,
                    contentDescription = "Posts",
                    // tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                    // 위에서 selected/unselectedContentColor를 지정했기 때문에 사실 필요가 없습니다..^^
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid( //리스트를 격자무늬로 보여줍니다.
        cells = GridCells.Fixed(3), // 3칸짜리..
//        modifier = modifier.scale(1.01f)
        // 하얀 구분선의 바깥쪽을 가리기 위한 트릭이라고 설명하는데
        // 제 기기에서는 탭 표시 막대를 가려서 주석처리 했습니다
    ) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop, //가로세로비율은 유지하고 남는부분 자르기
                modifier = Modifier
                    .aspectRatio(1f) // 가로 세로 1:1비율
                    .border( // 하얀 테두리
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
}