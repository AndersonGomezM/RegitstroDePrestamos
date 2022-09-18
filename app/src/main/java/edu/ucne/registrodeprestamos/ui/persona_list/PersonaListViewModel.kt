package edu.ucne.registrodeprestamos.ui.persona_list

import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import edu.ucne.registrodeprestamos.data.entity.PersonaEntity
import edu.ucne.registrodeprestamos.repository.PersonaRepository

data class PersonaListUiState(
    val personas: List<PersonaEntity> = emptyList(),
    val texto: String = "Meeting"
)

@HiltViewModel
class PersonaListViewModel @Inject constructor(
    val repository: PersonaRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(PersonaListUiState())
    val uiState: StateFlow<PersonaListUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getList().collect { list ->
                _uiState.update {
                    it.copy( personas = list )
                }
            }
        }
    }
}