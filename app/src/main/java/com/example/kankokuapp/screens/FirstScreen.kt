package com.example.kankokuapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.kankokuapp.navigation.AppScreens
import androidx.compose.material3.Text
import androidx.compose.runtime.*

@ExperimentalMaterial3Api
@Composable
fun FirstScreen(navController: NavController){
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Songs", "Artists", "Playlists")
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Text(text = "Primera Pantalla")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(route = AppScreens.Home.route)
                    }) {
                        Icon(Icons.Filled.ArrowForward, "forwardIcon")
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar() {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.Favorite, contentDescription = item) },
                        label = { Text(item) },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index }
                    )
                }
            }
        }
    )  {
        BodyContent(navController)
    }
}

@Composable
fun BodyContent(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Hola navegacion")
        Button(onClick = {
             navController.navigate(route = AppScreens.Home.route)
        }) {
            Text(text = "Navega")
        }
    }
}