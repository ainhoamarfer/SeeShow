package pmdm.seeshow.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import pmdm.seeshow.dominio.modelo.Serie
import pmdm.seeshow.seeder.seriePorId
import java.util.UUID




data class DetalleUIState(
    val serie: Serie
)

class PantallaDetalleVM : ViewModel() {
    private val _uiState = MutableStateFlow(DetalleUIState(serie = TODO()))

    val uiState: StateFlow<DetalleUIState> = _uiState.asStateFlow() //solo se puede consumir (leer)

    fun cargarSerie(serieId: Int) {

       _uiState.update {
          it.copy(serie = seriePorId(serieId))
       }
    }
}


