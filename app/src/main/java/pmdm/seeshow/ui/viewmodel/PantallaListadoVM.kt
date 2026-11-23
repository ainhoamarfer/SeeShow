package pmdm.seeshow.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import pmdm.seeshow.dominio.modelo.Serie
import pmdm.seeshow.seeder.datosSerie
import pmdm.seeshow.seeder.getSeriesFiltradas

//hay una unica fuente de verdad, el modelo
//esta lista no son todos los elementos que hay en la base de datos, son solo los que se muestran
data class PantallaListadoUIState(
    val listaSeries: List<Serie> = emptyList(),
    val searchText: String = "" //para poder usar la search bar
)

class PantallaListadoVM : ViewModel() {

    private val _uiState = MutableStateFlow(PantallaListadoUIState())

    val uiState: StateFlow<PantallaListadoUIState> = _uiState.asStateFlow() //es una versión capada del _uiState

    init {
        datosSerie()
    }

    //load
    fun cargarSeries() {

        _uiState.value = _uiState.value.copy(
            listaSeries = getSeriesFiltradas(_uiState.value.searchText)
        )
    }

    //cuando cambie la barra de busqueda
    fun onSearchTextChange(newText: String){

        _uiState.value = _uiState.value.copy(
            searchText = newText,
            listaSeries = getSeriesFiltradas(newText)
        )
    }
}













