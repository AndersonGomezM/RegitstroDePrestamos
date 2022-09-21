package edu.ucne.registrodeprestamos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import edu.ucne.registrodeprestamos.ui.theme.RegistroDePrestamosTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.ucne.registrodeprestamos.ui.ocupacion.OcupacionScreen
import edu.ucne.registrodeprestamos.ui.ocupacion_list.OcupacionListScreen
import edu.ucne.registrodeprestamos.util.Screen
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.registrodeprestamos.ui.home.HomeScreen
import edu.ucne.registrodeprestamos.ui.persona.PersonaScreen
import edu.ucne.registrodeprestamos.ui.persona_list.PersonaList
import edu.ucne.registrodeprestamos.ui.persona_list.PersonaListScreen
import java.util.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RegistroDePrestamosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.HomeScreen.route
                    ) {
                        composable(Screen.HomeScreen.route) {
                            HomeScreen(
                                onClickPersonas = { navController.navigate(Screen.PersonaListScreen.route) },
                                onClickOcupaciones = { navController.navigate(Screen.OcupacionListScreen.route) }
                            )
                        }

                        composable(Screen.PersonaListScreen.route) {
                            PersonaListScreen(
                                onClick = { navController.navigate(Screen.PersonaScreen.route) }
                            )
                        }

                        composable(Screen.PersonaScreen.route) {
                            PersonaScreen({ navController.navigateUp() })
                        }

                        composable(Screen.OcupacionListScreen.route) {
                            OcupacionListScreen(
                                onClick = { navController.navigate(Screen.OcupacionScreen.route) }
                            )
                        }

                        composable(Screen.OcupacionScreen.route) {
                            OcupacionScreen({ navController.navigateUp() })
                        }
                    }
                }
            }
        }
    }
}