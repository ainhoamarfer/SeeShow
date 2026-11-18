package pmdm.seeshow.ui.pagina

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import pmdm.seeshow.R
import pmdm.seeshow.ui.componente.BotonData
import pmdm.seeshow.ui.componente.Botones
import pmdm.seeshow.ui.componente.CabeceraSerieItem
import pmdm.seeshow.ui.componente.CabeceraSerieItemData
import pmdm.seeshow.ui.componente.ResenaPremium
import pmdm.seeshow.ui.componente.ResenaPremiumData
import pmdm.seeshow.ui.componente.VarianteBoton
import pmdm.seeshow.ui.theme.SeeShowTheme
import pmdm.seeshow.ui.viewmodel.PantallaDetalleVM

@Composable
fun PantallaDetalle(
    serieId: Int,
    modifier: Modifier = Modifier,
    vm: PantallaDetalleVM = viewModel()
) {

    val uiState by vm.uiState.collectAsState()

    LaunchedEffect(Unit) {
        vm.load(serieId)
    }

    //if (uiState.serie == null){
    //    Text(stringResource("La serie no se ha cargado todavía"))
    //}

    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(12.dp)) {

        CabeceraSerieItem(
            data = CabeceraSerieItemData(
                id = uiState.serie!!.id,
                //TODO hacerlo asi
                titulo = stringResource(R.string.titulo_serie_severance),
                fecha = stringResource(R.string.fecha_severance),
                creadaPor = stringResource(R.string.creada_por_seve),
                descripcion = stringResource(R.string.descripcion_seve),
                plataforma = stringResource(R.string.plataforma_seve),
                icono = android.R.drawable.ic_menu_camera, // Placeholder
                imagen = R.drawable.severance,
                imagenFondo = R.drawable.imagen_cabecera_severance
            )
        )

        ResenaPremium(
            data = ResenaPremiumData(
                resena = stringResource(R.string.resena_ejemplo),
                autor = stringResource(R.string.resena_autor),
            )
        )

        //Botonera
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Botones(
                enum = VarianteBoton.BASICO_INACTIVO,
                data = BotonData(
                    id = uiState.serie!!.id, //todo puede ser nulable
                    texto = stringResource(R.string.boton_temporada_capitulos),
                    onClic = {}
                )
            )
            Botones(
                enum = VarianteBoton.BASICO_INACTIVO,
                data = BotonData(
                    id = 1,
                    texto = stringResource(R.string.boton_temporada_capitulos),
                    onClic = {}
                )
            )
            Botones(
                enum = VarianteBoton.BASICO_INACTIVO,
                data = BotonData(
                    id = 1,
                    texto = stringResource(R.string.boton_temporada_capitulos), //TODO aRREGLAR PORQUE SE CORTA
                    onClic = {}
                )
            )
        }



    }
}

@Preview(showBackground = true)
@Composable
fun PantallaDetallePreview() {
    SeeShowTheme {
        Surface {
            Column(
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                PantallaDetalle(
                    serieId = 1
                )
            }

        }
    }
}