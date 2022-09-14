package edu.ucne.registrodeprestamos.ui.ocupacion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.ucne.registrodeprestamos.data.entity.OcupacionEntity
import edu.ucne.registrodeprestamos.repository.OcupacionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
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
                OcupacionEntity(
                    descripcion = descripcion,
                    sueldo = sueldo.toDouble()
                )
            )
        }
    }
}