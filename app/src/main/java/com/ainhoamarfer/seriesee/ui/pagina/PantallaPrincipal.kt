package com.ainhoamarfer.seriesee.ui.pagina

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ainhoamarfer.seriesee.ui.viewmodel.PantallaPrincipalVM
import androidx.compose.foundation.layout.*
import com.ainhoamarfer.seriesee.ui.componente.CabeceraImagen

@Composable
fun PantallaPrincipal(viewModel: PantallaPrincipalVM = viewModel(), modifier: Modifier){

    Column(modifier = modifier){
        CabeceraImagen(){

        }

    }
}

