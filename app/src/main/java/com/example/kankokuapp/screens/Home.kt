package com.example.kankokuapp.screens

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kankokuapp.R
import com.example.kankokuapp.navigation.AppScreens
import com.example.kankokuapp.components.StandardCard as StandardCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController) {
    var selectedItem by remember { mutableStateOf(0) }
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
        }
    ) {
        Column(modifier = Modifier
            .padding(10.dp)
            .verticalScroll(rememberScrollState())) {
            Row(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 10.dp)) {
                Icon(imageVector = Icons.Default.Person, tint = Color.Black, contentDescription = "")
                Text(text = " Asesores estrella.", color = Color.Black)
            }
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Row(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 10.dp)) {
                    Image(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(shape = RoundedCornerShape(50.dp))
                            .border(2.dp, Color.Black, RoundedCornerShape(50.dp)),
                        painter = painterResource(id = R.drawable.foto_de_perfil),
                        contentDescription = "Foto de perfil"
                    )
                    Text(text = "Marco Tavares", modifier = Modifier.padding(10.dp))
                }
                Row(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 10.dp)) {
                    Image(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(shape = RoundedCornerShape(50.dp))
                            .border(2.dp, Color.Black, RoundedCornerShape(50.dp)),
                        painter = painterResource(id = R.drawable.eduardo_rubio),
                        contentDescription = "Foto de perfil"
                    )
                    Text(text = "Eduardo Miguel", modifier = Modifier.padding(10.dp))
                }
            }
            Row() {
                Icon(imageVector = Icons.Default.Star, tint = Color.Black, contentDescription = "")
                Text(text = " Asesorias mas solicitadas.", color = Color.Black)
            }
            StandardCard(
                modifier = Modifier.padding(16.dp),
                background = Color.White,
                contentColor = Color.Black,
                nameAsesor = "Marco Tavares",
                materia = "Programacion Estructurada"
            )
            StandardCard(
                modifier = Modifier.padding(16.dp),
                background = Color.White,
                contentColor = Color.Black,
                nameAsesor = "Eduardo Miguel",
                materia = "Cisco II"
            )
            StandardCard(
                modifier = Modifier.padding(16.dp),
                background = Color.White,
                contentColor = Color.Black,
                nameAsesor = "Karlo Quiroga",
                materia = "Cultura Inglesa"
            )
        }
        Spacer(modifier = Modifier.padding(50.dp))
    }
}

data class NavBar(val name: String, val icon: ImageVector, val route: String)