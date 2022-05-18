package com.example.dogkotlin.presentation

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun AuthPage(navController: NavController) {
    var loginValue = remember{ mutableStateOf("") }
    var passwordValue = remember{ mutableStateOf("") }
    var onMain = false
    lateinit var auth: FirebaseAuth
    auth = Firebase.auth
    val currentUser = auth.currentUser
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(20.dp).fillMaxSize()
    ){
        val mContext = LocalContext.current
        Text("Агрегатор бродячих собак", color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(), fontSize = 25.sp)
        TextField(value = loginValue.value, onValueChange = {txt -> loginValue.value = txt}, modifier = Modifier.padding(10.dp))
        TextField(value = passwordValue.value, onValueChange = {txt -> passwordValue.value = txt}, modifier = Modifier.padding(10.dp))
        Button(onClick = {
            if (!(loginValue.value == "" || passwordValue.value == "")){

                auth.signInWithEmailAndPassword(loginValue.value, passwordValue.value)
                    .addOnCompleteListener() { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("login", "signInWithEmail:success")
                            val user = auth.currentUser
                            if (!onMain){
                                navController.navigate("MainPage")
                                onMain = true
                            }
                        } else {
                            Log.w("login", "signInWithEmail:failure", task.exception)
                            Toast.makeText(mContext, "Неверный логин или пароль", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
            else{
                Toast.makeText(mContext, "Поле ввода не может быть пустым", Toast.LENGTH_SHORT).show()
            }
        },
            colors = ButtonDefaults.buttonColors(Color.Blue), modifier = Modifier.clip(
                RoundedCornerShape(20)
            ).padding(10.dp)){
            Text("Войти", fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}