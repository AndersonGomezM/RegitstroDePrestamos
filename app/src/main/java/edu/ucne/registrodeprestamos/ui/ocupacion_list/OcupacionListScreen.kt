package edu.ucne.registrodeprestamos.ui.ocupacion_list

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
import edu.ucne.registrodeprestamos.data.entity.OcupacionEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OcupacionListScreen(
    onClick: () -> Unit,
    viewModel: OcupacionListViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text("Lista de ocupaciones",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis)})
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
    ocupaciones: List<OcupacionEntity>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(ocupaciones) { ocupacion ->
            OcupacionRow(ocupacion)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OcupacionRow(ocupacion: OcupacionEntity) {
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
                    text = ocupacion.descripcion,
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Row(
                modifier = Modifier.padding(4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "Sueldo: ${ocupacion.sueldo}"
                )

            }
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
@Preview(showSystemUi = true)
fun DefaultPreview() {
    val lista = listOf(

        OcupacionEntity(
            descripcion = "Contable",
            sueldo = 5000.00,
        ),
        OcupacionEntity(
            descripcion = "Ingeniero Civil",
            sueldo = 10000.00,
        )
    )

    OcupacionList(ocupaciones = lista)
}