package pmdm.seeshow.ui.pagina

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import pmdm.seeshow.ui.viewmodel.PantallaPrincipalVM
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text

@Composable
fun PantallaPrincipal(viewModel: PantallaPrincipalVM = viewModel(), modifier: Modifier = Modifier){

    Column(modifier = modifier){
//        CabeceraImagen(){
//
//        }

        Text(text = "soy principal")

    }
}

