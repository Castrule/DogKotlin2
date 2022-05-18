package com.example.dogkotlin.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.dogkotlin.R

@Composable
@Preview(showBackground = true)
fun AccountPage(navController: NavHostController = rememberNavController()){
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomBar(navController)
        }
    ) {
        AccountPageBody(navController)
    }
}
@Composable
fun AccountPageBody(navController: NavHostController){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        Image(painter = painterResource(R.drawable.anon), contentDescription = "desc",
            modifier = Modifier.clip(RoundedCornerShape(100)).size(150.dp))
        Text("Василий Пупкин", fontWeight = FontWeight.Bold, fontSize = 30.sp)
        Text("Волонтер с 17 мая 2022 года", color = Color.LightGray)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Icon(painter = painterResource(R.drawable.ic_baseline_star_24), contentDescription = "desc",
                modifier = Modifier.padding(5.dp))
            Icon(painter = painterResource(R.drawable.ic_baseline_star_24), contentDescription = "desc",
                modifier = Modifier.padding(5.dp))
            Icon(painter = painterResource(R.drawable.ic_baseline_star_24), contentDescription = "desc",
                modifier = Modifier.padding(5.dp))
            Icon(painter = painterResource(R.drawable.ic_baseline_star_24), contentDescription = "desc",
                modifier = Modifier.padding(5.dp))
            Icon(painter = painterResource(R.drawable.ic_baseline_star_24), contentDescription = "desc",
                modifier = Modifier.padding(5.dp))
        }
        Text("Рейтинг: 5 звёзд!", color = Color.LightGray,
            textAlign = TextAlign.Center, modifier = Modifier.padding(5.dp))
        Text("Добрые дела:", modifier = Modifier.padding(PaddingValues(horizontal = 20.dp)).fillMaxWidth(),
            fontWeight = FontWeight.Bold, fontSize = 30.sp)
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
                EventCard1(navController)
                Spacer(modifier = Modifier.size(10.dp))
                EventCard2(navController)
                Spacer(modifier = Modifier.size(10.dp))
        }
    }
}