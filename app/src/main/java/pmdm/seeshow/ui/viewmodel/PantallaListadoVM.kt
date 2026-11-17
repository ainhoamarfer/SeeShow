package pmdm.seeshow.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import pmdm.seeshow.dominio.modelo.Serie
import pmdm.seeshow.seeder.datosSerie


data class ListadoUIState(
    val series: List<Serie> = emptyList()
)

class PantallaListadoVM : ViewModel() {

    private val _uiState = MutableStateFlow(ListadoUIState())

    val uiState: StateFlow<ListadoUIState> = _uiState.asStateFlow()

    init {
        cargarSeries()
    }

    private fun cargarSeries() {
        val lista = datosSerie()

        _uiState.value = ListadoUIState(
            series = lista
        )
    }
}
