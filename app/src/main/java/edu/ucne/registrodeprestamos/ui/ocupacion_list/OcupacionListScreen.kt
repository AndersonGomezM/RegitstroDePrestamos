package edu.ucne.registrodeprestamos.ui.ocupacion_list

import android.content.Context
import android.content.Intent
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.hilt.navigation.compose.hiltViewModel
import edu.ucne.registrodeprestamos.model.Ocupacion
import edu.ucne.registrodeprestamos.ui.ocupacion.OcupacionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OcupacionListScreen(
    onClick: () -> Unit,
    viewModel: OcupacionListViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Lista de ocupaciones") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onClick) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Inserta una ocupaciíón")
            }
        }
    ) {

        val uiState by viewModel.uiState.collectAsState()

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(it)) {

            OcupacionList(
                ocupaciones = uiState.ocupaciones,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )
        }
    }
}

@Composable
fun OcupacionList(
    ocupaciones: List<Ocupacion>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(ocupaciones) { ocupacion ->
            OcupacionRow(ocupacion)
        }
    }
}

@Composable
fun OcupacionRow(ocupacion: Ocupacion) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(
            text = ocupacion.descripcion,
            style = MaterialTheme.typography.titleLarge
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Sueldo: ${ocupacion.sueldo}"
            )

        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            color = Color.Black
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun DefaultPreview() {
    val lista = listOf(

        Ocupacion(
            descripcion = "Contable",
            sueldo = 5000,
        ),
        Ocupacion(
            descripcion = "Ingeniero Civil",
            sueldo = 10000,
        )
    )

    OcupacionList(ocupaciones = lista)
}