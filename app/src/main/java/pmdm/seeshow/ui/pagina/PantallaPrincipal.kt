package pmdm.seeshow.ui.pagina

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import pmdm.seeshow.ui.viewmodel.PantallaPrincipalVM
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun PantallaPrincipal(viewModel: PantallaPrincipalVM = viewModel(), modifier: Modifier = Modifier){

    val state by viewModel.uiState.collectAsState() //observer que refresca la pantalla

    Column(modifier = modifier){
//        CabeceraImagen(){
//
//        }

        Text(text = "soy principal")

    }
}

