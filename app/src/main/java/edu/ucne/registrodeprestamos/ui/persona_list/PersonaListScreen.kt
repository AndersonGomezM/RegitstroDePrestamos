package edu.ucne.registrodeprestamos.ui.persona_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.ucne.registrodeprestamos.data.entity.PersonaEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonaListScreen(
    onClick: () -> Unit,
    viewModel: PersonaListViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text("Lista de personas",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis)})
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onClick) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Inserta una persona")
            }
        }
    ) {

        val uiState by viewModel.uiState.collectAsState()

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(it)) {

            PersonaList(
                personas = uiState.personas,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )
        }
    }
}

@Composable
fun PersonaList(
    personas: List<PersonaEntity>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(personas) { persona ->
            PersonaRow(persona)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonaRow(persona: PersonaEntity) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(85.dp),
        elevation = CardDefaults.cardElevation(16.dp),
        colors = CardDefaults.cardColors(Color(0x1E2196F3)
        )
    ) {
        Column(modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Row() {
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = persona.nombre,
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Row(
                modifier = Modifier.padding(4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "Celular: ${persona.celular}"
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
@Preview(showSystemUi = true)
fun DefaultPreview() {
    /*val lista = listOf(

        PersonaEntity(
            nombre = "Dani",
            telefono = "809-805-3040",
            celular = "849-353-3089",
            email = "DaniPhantome@gmail.com",
            direccion = "En el centro",
            fechaNacimiento = "",
            ocupacioId =
        ),
        PersonaEntity(
            descripcion = "Ingeniero Civil",
            sueldo = 10000.00,
        )
    )

    PersonaList(personas = lista)*/
}