package com.composemvimonolithtemplate.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.navigation.compose.rememberNavController
import com.composemvimonolithtemplate.presentation.navigation.BottomNavigation
import com.composemvimonolithtemplate.presentation.navigation.NavigationGraph
import com.composemvimonolithtemplate.presentation.theme.ComposeMviMonolithTemplateTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureCompose()
    }

    private fun configureCompose() {
        setContent {
            ComposeMviMonolithTemplateTheme {
                val navController = rememberNavController()

                Scaffold(bottomBar = { BottomNavigation(navController = navController) }) { innerPadding ->
                    NavigationGraph(navController = navController, innerPadding = innerPadding)
                }
            }
        }
    }
}