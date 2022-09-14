package edu.ucne.registrodeprestamos.ui.ocupacion_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.ucne.registrodeprestamos.data.entity.OcupacionEntity
import edu.ucne.registrodeprestamos.repository.OcupacionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class OcupacionListUiState(
    val ocupaciones: List<OcupacionEntity> = emptyList(),
    val texto: String = "Meeting"
)

@HiltViewModel
class OcupacionListViewModel @Inject constructor(
    val repository: OcupacionRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(OcupacionListUiState())
    val uiState: StateFlow<OcupacionListUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAll().collect { list ->
                _uiState.update {
                    it.copy( ocupaciones = list )
                }
            }
        }
    }
}