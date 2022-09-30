package com.example.kankokuapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AppScreens(
    val route:String,
    val icon: ImageVector,
    val title: String
    ){
    //Inicio de sesion
    object LoginMenu: AppScreens("login_menu", Icons.Default.Person,"Inicio de Sesion")
    //Alumnos
    object Home: AppScreens("home", Icons.Default.Home, "Inicio")
    object ConfigStudent: AppScreens("config_student", Icons.Default.Settings, "Configuracion de Estudiante")
    object CalendarStudent: AppScreens("calendar_student", Icons.Default.CalendarToday, "Calendario")
    object AdviserMenu: AppScreens("adviser_menu",  Icons.Default.CalendarToday, "Calendario")
    object DescriptionAdviser: AppScreens("description_adviser", Icons.Default.Description, "")
    //Asesoria
    object AdviserHome: AppScreens("adviser_home", Icons.Default.Home, "Inicio")
    object ConfigAdviser: AppScreens("config_adviser", Icons.Default.Settings, "Configuracion de Estudiante")
    //Alumnos y asesores
    object StudentProfile: AppScreens("student_profile", Icons.Default.Person, "Perfil de Estudiante")
    object AdviserProfile: AppScreens("adviser_profile", Icons.Default.Person, "Perfil de Estudiante")
    object CalendarAdviser: AppScreens("calendar_adviser", Icons.Default.CalendarToday, "Calendario")
    //Ayuda
    object Help: AppScreens("help", Icons.Default.Help, "Ayuda")
}

