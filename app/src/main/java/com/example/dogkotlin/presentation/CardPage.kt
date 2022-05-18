package com.example.dogkotlin.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun CardPage(navHostController: NavHostController = rememberNavController()) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter = painterResource(R.drawable.sobaka_png), contentDescription = "desc")
        Text("Бродячая", fontWeight = FontWeight.Bold,
            fontSize = 25.sp, modifier = Modifier.padding(10.dp))
        Column(
            modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState()).padding(10.dp),

            ){
            Text("Lorem ipsum — классический текст-«рыба» (условный, зачастую бессмысленный текст-заполнитель, вставляемый в макет страницы). Является искажённым отрывком из философского трактата Марка Туллия Цицерона «О пределах добра и зла[en]», написанного в 45 году до н. э. на латинском языке, обнаружение сходства приписывается Ричарду МакКлинтоку[1]. Распространился в 1970-х годах из-за трафаретов компании Letraset, a затем — из-за того, что служил примером текста в программе PageMaker. Испорченный текст, вероятно, происходит от его издания в Loeb Classical Library 1914 года, в котором слово dolorem разбито переносом так, что страница 36 начинается с lorem ipsum… (do- осталось на предыдущей)[2]. Lorem ipsum — классический текст-«рыба» (условный, зачастую бессмысленный текст-заполнитель, вставляемый в макет страницы). Является искажённым отрывком из философского трактата Марка Туллия Цицерона «О пределах добра и зла[en]», написанного в 45 году до н. э. на латинском языке, обнаружение сходства приписывается Ричарду МакКлинтоку[1]. Распространился в 1970-х годах из-за трафаретов компании Letraset, a затем — из-за того, что служил примером текста в программе PageMaker. Испорченный текст, вероятно, происходит от его издания в Loeb Classical Library 1914 года, в котором слово dolorem разбито переносом так, что страница 36 начинается с lorem ipsum… (do- осталось на предыдущей)[2]Lorem ipsum — классический текст-«рыба» (условный, зачастую бессмысленный текст-заполнитель, вставляемый в макет страницы). Является искажённым отрывком из философского трактата Марка Туллия Цицерона «О пределах добра и зла[en]», написанного в 45 году до н. э. на латинском языке, обнаружение сходства приписывается Ричарду МакКлинтоку[1]. Распространился в 1970-х годах из-за трафаретов компании Letraset, a затем — из-за того, что служил примером текста в программе PageMaker. Испорченный текст, вероятно, происходит от его издания в Loeb Classical Library 1914 года, в котором слово dolorem разбито переносом так, что страница 36 начинается с lorem ipsum… (do- осталось на предыдущей)[2]. Lorem ipsum — классический текст-«рыба» (условный, зачастую бессмысленный текст-заполнитель, вставляемый в макет страницы). Является искажённым отрывком из философского трактата Марка Туллия Цицерона «О пределах добра и зла[en]», написанного в 45 году до н. э. на латинском языке, обнаружение сходства приписывается Ричарду МакКлинтоку[1]. Распространился в 1970-х годах из-за трафаретов компании Letraset, a затем — из-за того, что служил примером текста в программе PageMaker. Испорченный текст, вероятно, происходит от его издания в Loeb Classical Library 1914 года, в котором слово dolorem разбито переносом так, что страница 36 начинается с lorem ipsum… (do- осталось на предыдущей)[2]",
                color = Color.DarkGray)
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
            Text("Этой организации можно доверять", color = Color.LightGray, textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth())
        }
    }
}