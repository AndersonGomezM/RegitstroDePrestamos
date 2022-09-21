package edu.ucne.registrodeprestamos.ui.prestamo

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
import edu.ucne.registrodeprestamos.data.entity.PrestamoEntity
import androidx.compose.material.DropdownMenuItem
import edu.ucne.registrodeprestamos.data.entity.PersonaEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonaScreen(
    onNavigateBack: () -> Unit,
    viewModel: PrestamoViewModel = hiltViewModel()
) {
    var nameError by remember { mutableStateOf(false) }
    val assistiveElementText = if (nameError) "Campo obligatorio" else "*Obligatorio" // 4
    val assistiveElementColor = if (nameError) { // 5
        colors.error
    } else {
        colors.onSurface.copy(alpha = ContentAlpha.medium)
    }
    var personaselected by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val personas = listOf(
        PersonaEntity(
            nombre = "Rodrigo",
            telefono = "809-580-3008",
            celular = "849-320-8590",
            email = "RodrigoIngeniero@gmail.com",
            direccion = "Casita",
            fechaNacimiento = "20/09/2000",
            ocupacioId = 1
        )
    )
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Prestamos") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.save()
                onNavigateBack()
            }) {
                Icon(imageVector = Icons.Default.Create, contentDescription = "Inserte un prestamo")
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
                label = { Text(text = "Fecha") },
                value = viewModel.fecha,
                onValueChange = { viewModel.fecha = it }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Vence") },
                value = viewModel.vence,
                onValueChange = { viewModel.vence = it }
            )

            OutlinedTextField(
                label = { Text(text = "Personas") },
                value = personaselected,
                onValueChange = { personaselected = it },
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
                personas.forEach { persona ->
                    DropdownMenuItem(onClick = {
                        expanded = false
                        personaselected = persona.nombre
                        viewModel.personaId = personaselected
                    }) {
                        Text(text = persona.nombre)
                    }
                }
            }
            if(viewModel.personaId.length <= 0)
            {
                Text(// 6
                    text = assistiveElementText,
                    color = assistiveElementColor,
                    style = typography.caption,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Concepto") },
                value = viewModel.concepto,
                onValueChange = { viewModel.concepto = it }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Monto") },
                value = viewModel.monto,
                onValueChange = { viewModel.monto = it }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Balance") },
                value = viewModel.balance,
                onValueChange = {viewModel.balance = it}
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun DefaultPreview() {
    PersonaScreen({})
}