package edu.ucne.registrodeprestamos.ui.prestamo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.registrodeprestamos.data.entity.PrestamoEntity
import edu.ucne.registrodeprestamos.repository.PrestamoRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PrestamoViewModel @Inject constructor(
    val repository: PrestamoRepository
) : ViewModel() {

    var fecha by mutableStateOf("")
    var vence by mutableStateOf("")
    var personaId by mutableStateOf("")
    var concepto by mutableStateOf("")
    var monto by mutableStateOf("")
    var balance by mutableStateOf("")

    fun save(){
        viewModelScope.launch {
            repository.insertarPrestamo(
                PrestamoEntity(
                    fecha = fecha,
                    vence = vence,
                    personaId = personaId.toInt(),
                    concepto = concepto,
                    monto = monto.toDouble(),
                    balance = balance.toDouble()
                )
            )
        }
    }
}