package pmdm.seeshow.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class PantallaLogInUIState(
    val email: String = "",
    val contrasena: String = "",
    val errorEmail: String? = null,
    val errorContra: String? = null,
    val expanded: Boolean = false
)

class PantallaLogInVM : ViewModel() {

    private val _uiState = MutableStateFlow(PantallaLogInUIState())
    val uiState: StateFlow<PantallaLogInUIState> = _uiState.asStateFlow()

    fun onEmailChange(newText: String) {
        _uiState.value = _uiState.value.copy(errorEmail = null) //limpio el error

        _uiState.value = _uiState.value.copy(email = newText) //actualizo

        if(_uiState.value.email.isBlank()) {
            _uiState.value = _uiState.value.copy(errorEmail = "El email no puede estar vacio") //compruebo si hay error
        }
    }

    fun onContraChange(newText: String) {
        _uiState.value = _uiState.value.copy(errorContra = null) //limpio el error

        _uiState.value = _uiState.value.copy(contrasena = newText)

        if(_uiState.value.email.isBlank()) {
            _uiState.value = _uiState.value.copy(errorContra = "El email no puede estar vacio")
        }
    }

    //fun isError(): Boolean {
    // return _uiState.value.error }

    fun onExpandedChange(it: Boolean): Unit {
        _uiState.value = _uiState.value.copy(expanded = it)
    }
}