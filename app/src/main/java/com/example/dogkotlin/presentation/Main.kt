package com.example.dogkotlin.presentation

import android.graphics.Paint
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.dogkotlin.R

@Composable
@Preview(showBackground = true)
fun MainPage(navController: NavHostController = rememberNavController()) {
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomBar(navController)
        }
    ) {
        Body(navController)
    }
}
@Composable
fun TopBar(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ){
        Text("DogFree", color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(5.dp), fontSize = 25.sp)
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(painter = painterResource(R.drawable.ic_baseline_menu_24),
                contentDescription = "desc", modifier = Modifier
                    .padding(10.dp)
                    .size(30.dp))
        }
    }
}
@Composable
fun BottomBar(navController: NavHostController){
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Button(onClick = {navController.navigate("MainPage")},
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            elevation = ButtonDefaults.elevation(0.dp),
            modifier = Modifier.height(44.dp)
                .background(color = Color.Transparent)
                .weight(1f)
                .fillMaxWidth()){
            Icon(painter = painterResource(R.drawable.ic_baseline_home_24),
                contentDescription = "desc")
        }
        Button(onClick = {navController.navigate("MapPage")},
            elevation = ButtonDefaults.elevation(0.dp),
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            modifier = Modifier.height(44.dp)
                .background(color = Color.Transparent)
                .weight(1f)
                .fillMaxWidth()){
            Icon(painter = painterResource(R.drawable.ic_baseline_search_24),
                contentDescription = "desc")
        }
        Button(onClick = {navController.navigate("AccountPage")},
            elevation = ButtonDefaults.elevation(0.dp),
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            modifier = Modifier.height(44.dp)
                .weight(1f)
                .fillMaxWidth()){
            Icon(painter = painterResource(R.drawable.ic_baseline_person_24),
                contentDescription = "desc")
        }
        Button(onClick = {navController.navigate("AccountPage")},
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            elevation = ButtonDefaults.elevation(0.dp),
            modifier = Modifier.height(44.dp)
                .weight(1f)
                .fillMaxWidth()){
            Icon(painter = painterResource(R.drawable.ic_baseline_more_horiz_24),
                contentDescription = "desc")
        }
    }
}
@Composable
fun Body(navController: NavHostController){
    Column(

        modifier = Modifier
            .verticalScroll(rememberScrollState())
            //.background(color = Color.LightGray)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Карта", modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(), fontWeight = FontWeight.Bold, fontSize = 30.sp, textAlign = TextAlign.Left)
        Box(modifier = Modifier
            .clip(RoundedCornerShape(10))
            .width(300.dp)
            .height(168.dp)){
            Image(painter = painterResource(id = R.drawable.dogs), contentDescription = "desc")
        }
        Spacer(modifier = Modifier.size(10.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
            horizontalArrangement = Arrangement.Center
        ){
            FilterButton(R.drawable.ic_baseline_filter_list_24, "фильтр")
            Spacer(modifier = Modifier.size(20.dp))
            FilterButton(R.drawable.ic_baseline_near_me_24, "поблизости")
        }
            EventCard1(navController)
            Spacer(modifier = Modifier.size(10.dp))
            EventCard2(navController)
            Spacer(modifier = Modifier.size(10.dp))
    }
}
@Composable
fun EventCard1(navController: NavHostController){
    Button(onClick = {navController.navigate("CardPage")},
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        elevation = ButtonDefaults.elevation(0.dp)
    ){
        Card(
            elevation = 0.dp,
            modifier = Modifier
                .clip(RoundedCornerShape(10))
                .height(200.dp)
                .width(300.dp)
                .padding(0.dp),

            ){
            Image(painter = painterResource(id = R.drawable.sobaka_png), contentDescription = "desc",
                modifier = Modifier
                    .fillMaxSize())
            Text("Немецкая овчарка", textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(40.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Black,
                                Color.Transparent,
                                Color.Transparent
                            )
                        )
                    ), color = Color.White,
                fontWeight = FontWeight.Bold)
        }
    }
}
@Composable
fun EventCard2(navController: NavHostController){
    Button(onClick = {navController.navigate("CardPage")},
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        elevation = ButtonDefaults.elevation(0.dp)
    ){
        Card(
            elevation = 0.dp,
            modifier = Modifier
                .clip(RoundedCornerShape(10))
                .height(200.dp)
                .width(300.dp)
                .padding(0.dp),

            ){
            Image(painter = painterResource(id = R.drawable.sobaka2_png), contentDescription = "desc",
                modifier = Modifier
                    .fillMaxSize())
            Text("Золотой ретиривер", textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(40.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Black,
                                Color.Transparent,
                                Color.Transparent
                            )
                        )
                    ), color = Color.White,
                fontWeight = FontWeight.Bold)
        }
    }
}
@Composable
fun FilterButton(image: Int, text: String){
    Row(modifier = Modifier
        .clip(RoundedCornerShape(40))
        .background(color = Color.Black)
        .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically){
        Image(painter = painterResource(id = image), contentDescription = "desc")
        Spacer(modifier = Modifier.size(5.dp))
        Text(text, color = Color.White, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(PaddingValues(horizontal = 5.dp)))
    }
}