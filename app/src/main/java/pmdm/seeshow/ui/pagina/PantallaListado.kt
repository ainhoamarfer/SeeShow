package pmdm.seeshow.ui.pagina


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import pmdm.seeshow.R
import pmdm.seeshow.seeder.datosSerie
import pmdm.seeshow.ui.componente.DatosSerieListadoCard
import pmdm.seeshow.ui.componente.SerieListadoCard
import pmdm.seeshow.ui.componente.TipoSerieCard
import pmdm.seeshow.ui.theme.SeeShowTheme
import pmdm.seeshow.ui.viewmodel.PantallaDetalleVM

//TODO HACER LAS MODIFICACIONES DE CARDS HORIZONTAL Y GRANDE
@Composable
fun PantallaListado(
    serieId: String,
    onRelacionadoClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: PantallaDetalleVM = viewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.cargarSerie(serieId)
    }

    val serie = uiState.serie

    //Lista de prueba para la parte de abajo (4 en 4)
    val listaSeriesRestantes = datosSerie()

    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = modifier.fillMaxSize(),
        //contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        //ILA DE ARRIBA, EL SPAN PARA QUE OCUPE 4 HUECOS
        item(span = { GridItemSpan(4) }) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                //columna izquierda: Tarjeta grande
                Box(modifier = Modifier.weight(1f)) {
                    SerieListadoCard(
                        datos = DatosSerieListadoCard(
                            id = 1,
                            recursoImagen = R.drawable.succesion,
                            titulo = "Succession",
                            subtitulo = "T3 · 28 Caps",
                            puntuacion = "4.9",
                            porcentajeCompletada = "24%",
                            tipo = TipoSerieCard.VERTICAL_GRANDE
                        )
                    )
                }

                //columna derecha: dos horizontales
                Column(
                    modifier = Modifier.weight(1f), //TODO entender esto
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    SerieListadoCard(
                        datos = DatosSerieListadoCard(
                            id = 1,
                            recursoImagen = R.drawable.succesion,
                            titulo = "Succession",
                            subtitulo = "T3 · 28 Caps",
                            puntuacion = "4.9",
                            porcentajeCompletada = "24%",
                            tipo = TipoSerieCard.HORIZONTAL
                        )
                    )
                    SerieListadoCard(
                        datos = DatosSerieListadoCard(
                            id = 1,
                            recursoImagen = R.drawable.succesion,
                            titulo = "Succession",
                            subtitulo = "T3 · 28 Caps",
                            puntuacion = "4.9",
                            porcentajeCompletada = "24%",
                            tipo = TipoSerieCard.HORIZONTAL
                        )
                    )
                }
            }
        }

        //RESTO DE LA LISTA
        items(listaSeriesRestantes) { serie ->
            SerieListadoCard(
                datos = serie,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SeeShowTheme {
        Surface {
            PantallaListado()
        }
    }
}