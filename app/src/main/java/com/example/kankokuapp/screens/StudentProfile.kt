package com.example.kankokuapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kankokuapp.R
import com.example.kankokuapp.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentProfile(navController: NavController){
    var selectedItem by remember { mutableStateOf(1) }
    val items = listOf(
        NavBar("Inicio", Icons.Default.Home, AppScreens.Home.route),
        NavBar("Perfil", Icons.Default.Person, AppScreens.StudentProfile.route),
        NavBar("Asesores", Icons.Default.Description, AppScreens.AdviserMenu.route),
        NavBar("Calendario", Icons.Default.CalendarToday, AppScreens.CalendarStudent.route)
    )
    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(item.icon, contentDescription = item.name) },
                        label = { Text(item.name) },
                        selected = selectedItem == index,
                        onClick = {
                            selectedItem = index
                            navController.navigate(route = item.route)
                        }
                    )
                }
            }
        },
        content = {
            Column() {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                )
                {
                    Image(
                        modifier = Modifier
                            .fillMaxSize(),
                        painter = painterResource(id = R.drawable.purple_background),
                        contentDescription = "Fondo"
                    )
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = CenterHorizontally
                    ) {
                        Image(
                            modifier = Modifier
                                .size(100.dp)
                                .clip(shape = RoundedCornerShape(50.dp))
                                .border(2.dp, Color.White, RoundedCornerShape(50.dp)),
                            painter = painterResource(id = R.drawable.foto_de_perfil),
                            contentDescription = "Foto de perfil"
                        )
                        Text(text = "Marco Tavares", color = Color.White)
                        Text(text = "Ingeniero en Tecnologia de Software", color = Color.White, fontWeight = FontWeight.ExtraLight)
                    }
                }
                Column(modifier = Modifier.padding(10.dp,0.dp,10.dp,0.dp)) {
                    Row() {
                        Icon(imageVector = Icons.Default.FormatListNumbered, tint = Color.Gray, contentDescription = "")
                        Text(text = " Matricula:", color = Color.Gray)
                    }
                    Text(text = "1991994", modifier = Modifier.padding(25.dp, 5.dp, 0.dp, 10.dp))
                    Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 10.dp))
                    Row() {
                        Icon(imageVector = Icons.Default.ViewStream, tint = Color.Gray, contentDescription = "")
                        Text(text = " Materias en el semestre:", color = Color.Gray)
                    }
                    val bullet = "\u2022"
                    val messages = listOf(
                        "Redes neuronales artificiales",
                        "Verificacion y Validacion de Software",
                        "Seguridad de la informacion",
                        "Controladores y Microcontroladores",
                        "Ingenieria en Dispositivos Moviles",
                        "Automatizacion y Control",
                        "Sistemas Distribuidos y Paralelos"
                    )
                    val paragraphStyle = ParagraphStyle(textIndent = TextIndent(restLine = 12.sp))
                    Text(
                        buildAnnotatedString {
                            messages.forEach {
                                withStyle(style = paragraphStyle) {
                                    append(bullet)
                                    append("\t\t")
                                    append(it)
                                }
                            }
                        }, modifier = Modifier.padding(25.dp, 5.dp, 0.dp, 10.dp)
                    )
                    Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 10.dp))
                    Row() {
                        Icon(imageVector = Icons.Default.Grade, tint = Color.Gray, contentDescription = "")
                        Text(text = " Calificacion general:", color = Color.Gray)
                    }
                    Text(text = "86.07", modifier = Modifier.padding(25.dp, 5.dp, 0.dp, 10.dp))
                    Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 10.dp))
                }
            }
            
        }
    )
}