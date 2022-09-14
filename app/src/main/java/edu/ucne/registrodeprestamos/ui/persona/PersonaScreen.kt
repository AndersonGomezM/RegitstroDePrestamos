package edu.ucne.registrodeprestamos.ui.persona

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.ucne.registrodeprestamos.data.entity.OcupacionEntity
import androidx.compose.material.DropdownMenuItem
import edu.ucne.registrodeprestamos.ui.ocupacion.OcupacionViewModel
import edu.ucne.registrodeprestamos.ui.persona.PersonaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonaScreen(
    onNavigateBack: () -> Unit,
    viewModel: PersonaViewModel = hiltViewModel()
) {
    var nameError by remember { mutableStateOf(false) }
    val assistiveElementText = if (nameError) "Campo obligatorio" else "*Obligatorio" // 4
    val assistiveElementColor = if (nameError) { // 5
        colors.error
    } else {
        colors.onSurface.copy(alpha = ContentAlpha.medium)
    }
    var ocupacionselected by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val ocupaciones = listOf(
        OcupacionEntity(descripcion = "Ingeniero", sueldo = 60000.00),
        OcupacionEntity(descripcion = "Contador", sueldo = 40000.00)
    )
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Personas") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.Save()
                onNavigateBack()
            }) {
                Icon(imageVector = Icons.Default.Create, contentDescription = "Inserte una persona")
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(8.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Nombre") },
                value = viewModel.nombre,
                onValueChange = { viewModel.nombre = it }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Telefono") },
                value = viewModel.telefono,
                onValueChange = { viewModel.telefono = it }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Celular") },
                value = viewModel.celular,
                onValueChange = { viewModel.celular = it }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Email") },
                value = viewModel.email,
                onValueChange = { viewModel.email = it }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Dirección") },
                value = viewModel.direccion,
                onValueChange = { viewModel.direccion = it }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Fecha de Nacimiento") },
                value = viewModel.fechaNacimiento,
                onValueChange = {viewModel.fechaNacimiento = it})
            if(viewModel.fechaNacimiento.length <= 0)
            {
                Text(// 6
                    text = assistiveElementText,
                    color = assistiveElementColor,
                    style = typography.caption,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }

            OutlinedTextField(
                label = { Text(text = "Ocupaciones") },
                value = ocupacionselected,
                onValueChange = { ocupacionselected = it },
                enabled = false, readOnly = true,
                modifier = Modifier
                    .clickable { expanded = true }
                    .fillMaxWidth()
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth()
            )
            {
                ocupaciones.forEach { ocupacion ->
                    DropdownMenuItem(onClick = {
                        expanded = false
                        ocupacionselected = ocupacion.descripcion
                        viewModel.ocupacioId = ocupacionselected
                    }) {
                        Text(text = ocupacion.descripcion)
                    }
                }
            }
            if(viewModel.ocupacioId.length <= 0)
            {
                Text(// 6
                    text = assistiveElementText,
                    color = assistiveElementColor,
                    style = typography.caption,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }

        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun DefaultPreview() {
    PersonaScreen({})
}