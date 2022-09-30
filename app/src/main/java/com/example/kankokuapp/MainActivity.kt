package com.example.kankokuapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.kankokuapp.navigation.AppNavigation
import com.example.kankokuapp.ui.theme.KankokuAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KankokuAppTheme{
                AppNavigation()
            }
        }
    }
}