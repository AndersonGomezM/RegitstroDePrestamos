package edu.ucne.registrodeprestamos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import edu.ucne.registrodeprestamos.ui.theme.RegistroDePrestamosTheme
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.core.app.ActivityCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.ucne.registrodeprestamos.ui.ocupacion.OcupacionScreen
import edu.ucne.registrodeprestamos.ui.ocupacion_list.OcupacionListScreen
import edu.ucne.registrodeprestamos.util.Screen
import dagger.hilt.android.AndroidEntryPoint
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
                        startDestination = Screen.OcupacionScreen.route
                    ) {
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

@Preview(showBackground = true, showSystemUi = true)

@Composable
fun DefaultPreview() {
    RegistroDePrestamosTheme {
    }
}