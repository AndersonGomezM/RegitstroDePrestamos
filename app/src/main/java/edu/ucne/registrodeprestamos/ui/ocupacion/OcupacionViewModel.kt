package edu.ucne.registrodeprestamos.ui.ocupacion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.ucne.registrodeprestamos.model.Ocupacion
import edu.ucne.registrodeprestamos.repository.OcupacionRepository
import edu.ucne.registrodeprestamos.ui.ocupacion_list.OcupacionListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OcupacionViewModel @Inject constructor(
    val repository: OcupacionRepository
) : ViewModel() {

    var descripcion by mutableStateOf("")
    var sueldo by mutableStateOf("")

    fun Save(){
        viewModelScope.launch {
            repository.insertOcupacion(
                Ocupacion(
                    descripcion = descripcion,
                    sueldo = sueldo.toFloat()
                )
            )
        }
    }
}