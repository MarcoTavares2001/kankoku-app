package com.example.kankokuapp.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kankokuapp.screens.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.LoginMenu.route){
        composable(route = AppScreens.LoginMenu.route){
            LoginMenu(navController)
        }
        composable(route = AppScreens.Home.route){
            Home(navController)
        }
        composable(route = AppScreens.ConfigStudent.route){
            ConfigStudent(navController)
        }
        composable(route = AppScreens.CalendarStudent.route){
            CalendarStudent(navController)
        }
        composable(route = AppScreens.AdviserMenu.route){
            AdviserMenu(navController)
        }
        composable(route = AppScreens.DescriptionAdviser.route){
            DescriptionAdviser(navController)
        }
        composable(route = AppScreens.AdviserHome.route){
            AdviserHome(navController)
        }
        composable(route = AppScreens.ConfigAdviser.route){
            ConfigAdviser(navController)
        }
        composable(route = AppScreens.StudentProfile.route){
            StudentProfile(navController)
        }
        composable(route = AppScreens.AdviserProfile.route){
            AdviserProfile(navController)
        }
        composable(route = AppScreens.CalendarAdviser.route){
            CalendarAdviser(navController)
        }
        composable(route = AppScreens.Help.route){
            Help()
        }
    }
}