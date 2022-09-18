package edu.ucne.registrodeprestamos.ui.home

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onClick: () -> Unit,
    onClickPerson: () -> Unit
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

            IconButton(onClick = onClick) {
                Icon(imageVector = Icons.Outlined.Add, contentDescription = "Ocupaciones")
            }
            IconButton(onClick = onClickPerson) {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Personas")
            }
        }
    )
}