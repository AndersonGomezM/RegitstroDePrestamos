package edu.ucne.registrodeprestamos.ui.ocupacion

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OcupacionScreen(
    onNavigateBack: () -> Unit,
    viewModel: OcupacionViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    fun validacion() {
        if (viewModel.descripcion.isBlank() || viewModel.sueldo.isBlank()){
            Toast.makeText(
                context,
                "Debe rellenar la casilla vacia",
                Toast.LENGTH_SHORT
            ).show()
        }else{
            viewModel.save()
            onNavigateBack()
        }
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Ocupaciones") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                validacion()
            }) {
                Icon(imageVector = Icons.Default.Create, contentDescription = "Inserte una ocupación")
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
                label = { Text(text = "Descripción") },
                value = viewModel.descripcion,
                onValueChange = { viewModel.descripcion = it }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Sueldo") },
                value = viewModel.sueldo,
                onValueChange = { viewModel.sueldo = it },
                keyboardOptions = KeyboardOptions( keyboardType = KeyboardType.Number)
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun DefaultPreview() {
    OcupacionScreen({})
}