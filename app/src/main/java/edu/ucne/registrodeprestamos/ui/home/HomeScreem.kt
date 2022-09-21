package edu.ucne.registrodeprestamos.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.Text
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.material.MaterialTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onClickPersonas: () -> Unit,
    onClickOcupaciones: () -> Unit
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    TopAppBar(
        title = { Text(text = "Aplicacion de Prestamos") },
        navigationIcon = {
            Icon(imageVector = Icons.Rounded.Menu, contentDescription = null )
        },
        actions = {

            IconButton(onClick = onClickPersonas) {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Personas")
            }

            IconButton(onClick = onClickOcupaciones) {
                Icon(imageVector = Icons.Outlined.Add, contentDescription = "Ocupaciones")
            }
        }
    )
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ){

    }
}