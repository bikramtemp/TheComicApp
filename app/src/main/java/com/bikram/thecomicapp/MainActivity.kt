package com.bikram.thecomicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.bikram.thecomicapp.ui.screens.HomeScreen
import com.bikram.thecomicapp.ui.theme.TheComicAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheComicAppTheme {
                // Home screen with a Scaffold for app
                // bar and bottom navigation tabs
                HomeScreen()
            }
        }
    }
}