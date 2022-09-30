package com.example.kankokuapp.screens

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.kankokuapp.components.StandardCard
import com.example.kankokuapp.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdviserMenu(navController: NavHostController) {
    var selectedItem by remember { mutableStateOf(2) }
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
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
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
                nameAsesor = "Asaf Olvera",
                materia = "Matematicas II"
            )
            StandardCard(
                modifier = Modifier.padding(16.dp),
                background = Color.White,
                contentColor = Color.Black,
                nameAsesor = "Alfonso Osti",
                materia = "Cisco I"
            )
            Spacer(modifier = Modifier.padding(50.dp))
        }
    }
}