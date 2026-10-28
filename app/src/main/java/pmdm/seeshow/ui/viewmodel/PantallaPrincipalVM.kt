package pmdm.seeshow.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class DatosTarjeta(
    val titulo: String,
    val descripcion: String
)

data class PantallaPrincipalUIState(
    var datosTarjeta: List<DatosTarjeta> = listOf()
    )

//es necesario que la pantalla principal herede de ViewModel, genera una instancia que se repite
class PantallaPrincipalVM : ViewModel(){
    private val _uiState = MutableStateFlow(PantallaPrincipalUIState())
    val uiState: StateFlow<PantallaPrincipalUIState> = _uiState.asStateFlow() //solo se puede consumir (leer)

    fun load(){
        //cargo los datos
        _uiState.value = _uiState.value.copy(datosTarjeta = listOf(
            DatosTarjeta("Titulo 1", "Descripcion 1"),
            DatosTarjeta("Titulo 2", "Descripcion 2"),
            DatosTarjeta("Titulo 3", "Descripcion 3"),
        ))

    }

    fun onBorrar(item: DatosTarjeta){
        Log.d("botonBorrar", "accion borrar ${item.titulo}")
    }
    fun onVerMás(item: DatosTarjeta){
        Log.d("botonVerMás", "accion Ver Más ${item.titulo}")
    }
}