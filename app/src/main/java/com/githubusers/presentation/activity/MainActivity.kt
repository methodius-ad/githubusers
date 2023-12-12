package com.githubusers.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.navigation.compose.rememberNavController
import com.githubusers.presentation.navigation.NavigationGraph
import com.githubusers.presentation.theme.ComposeMviMonolithTemplateTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureCompose()
    }

    private fun configureCompose() {
        setContent {
            ComposeMviMonolithTemplateTheme {
                val navController = rememberNavController()

                Scaffold { innerPadding ->
                    NavigationGraph(navController = navController, innerPadding = innerPadding)
                }
            }
        }
    }
}