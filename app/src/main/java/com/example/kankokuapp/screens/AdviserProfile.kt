package com.example.kankokuapp.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.example.kankokuapp.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdviserProfile(navController: NavController){
    var selectedItem by remember { mutableStateOf(1) }
    val items = listOf(
        NavBar("Inicio", Icons.Default.Home, AppScreens.AdviserHome.route),
        NavBar("Perfil", Icons.Default.Person, AppScreens.AdviserProfile.route),
        NavBar("Calendario", Icons.Default.CalendarToday, AppScreens.CalendarAdviser.route)
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

    }
}