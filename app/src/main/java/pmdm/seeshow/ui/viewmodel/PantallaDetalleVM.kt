package pmdm.seeshow.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import pmdm.seeshow.dominio.modelo.Serie
import pmdm.seeshow.seeder.datosSerie
import pmdm.seeshow.seeder.getActoresCard
import pmdm.seeshow.seeder.getSerie
import pmdm.seeshow.ui.componente.DatosSerieListadoCard



data class DetalleUIState(
    val serie: Serie? = null,
    //val errorMsg: String? = null
    val actores: List<DatosSerieListadoCard> = emptyList(),
    val seriesRelacionadas: List<Serie> = emptyList()
)

class PantallaDetalleVM : ViewModel() {
    private val _uiState = MutableStateFlow(DetalleUIState())
    val uiState: StateFlow<DetalleUIState> = _uiState.asStateFlow() //solo se puede consumir (leer)


    fun getSeriesRelacionadas(): List<Serie> {
        return datosSerie().shuffled().take(5)
    }

    fun load(id: Int) {

        _uiState.value = _uiState.value.copy(
            serie = getSerie(id),
            actores = getActoresCard(),
            seriesRelacionadas = getSeriesRelacionadas()
        )
    }
}


