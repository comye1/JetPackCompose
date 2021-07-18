package com.example.navigationforbiginners

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyNavigation() {
    /*
    핵심 요소는 NavController
    - stateful
    - keep track of the back stack of composables
    - rememberNavController()로 생성
    = navController를 참조할 모든 composable이 접근할 수 있는 위치에 생성 -> state hoisting!!
    - currentBackStackEntryAsStae를 통해 제공하는 state는 composable을 화면 외부에서
    업데이트 하기 위한 source of truth로 사용된다.
     */
    val navController = rememberNavController()
    /*
    NavHost
    - 각 NavController는 NavHost 하나씩과 연관되어야 한다.
    - NavHost가 NavController를 navigation graph와 연결한다.
    - navigate할 때마다 NavHost의 recomposition이 일어난다.
    - 각 destination composable은 route 하나씩과 연관된다.
    Route
    - implicit deep link라고 생각할 수 있다.
    - 모든 destination은 구별되는 route가 있어야 한다.

    * Principles of Navigation - fixed starting destination
     */

    NavHost(navController = navController, startDestination = "profile"){
        // NavGraphBuilder
        composable("profile"){

        }
        composable("friendslist"){}
    }
}

@Composable
fun Profile(navController: NavController) {

    /*
    콜백에서만 naviagte()를 호출하여야 한다 (composable 안에서 그냥 호출하면 안됨)
    navigate()는 back stack에 새로운 destination을 추가함, 옵션 설정 가능
     */
    Button(onClick = { navController.navigate("friends") }) {
        Text(text = "Navigate next")
    }

}
