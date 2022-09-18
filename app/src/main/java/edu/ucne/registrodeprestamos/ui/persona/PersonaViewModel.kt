package edu.ucne.registrodeprestamos.ui.persona

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.registrodeprestamos.data.entity.PersonaEntity
import edu.ucne.registrodeprestamos.repository.PersonaRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonaViewModel @Inject constructor(
    val repository: PersonaRepository
) : ViewModel() {

    var nombre by mutableStateOf("")
    var telefono by mutableStateOf("")
    var celular by mutableStateOf("")
    var email by mutableStateOf("")
    var direccion by mutableStateOf("")
    var fechaNacimiento by mutableStateOf("")
    var ocupacionId by mutableStateOf("")

    fun save(){
        viewModelScope.launch {
            repository.insertarPersona(
                PersonaEntity(
                    nombre = nombre,
                    telefono = telefono,
                    celular = celular,
                    email = email,
                    direccion = direccion,
                    fechaNacimiento = fechaNacimiento,
                    ocupacioId = ocupacionId.toInt()
                )
            )
        }
    }
}