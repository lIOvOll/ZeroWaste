package com.example.zerowaste



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.zerowaste.ui.theme.ZeroWasteTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.zerowaste.screens.AnorganikSreen
import com.example.zerowaste.screens.HomeScreen
import com.example.zerowaste.screens.OrganikScreen



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            ZeroWasteTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "home"
                ){
                    composable("home"){
                        HomeScreen(navController)
                    }
                    composable("OrganikInfo"){
                        OrganikScreen(navController)
                    }
                    composable ("AnorganikInfo"){
                        AnorganikSreen(navController)
                    }
                }

            }
        }
    }
}





