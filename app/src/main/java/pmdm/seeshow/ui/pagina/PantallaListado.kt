package pmdm.seeshow.ui.pagina

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pmdm.seeshow.R
import pmdm.seeshow.seeder.getDatosSerie
import pmdm.seeshow.ui.componente.DatosSerieListadoCard
import pmdm.seeshow.ui.componente.SerieListadoCard
import pmdm.seeshow.ui.componente.TipoSerieCard
import pmdm.seeshow.ui.theme.SeeShowTheme

//TODO HACER LAS MODIFICACIONES DE CARDS HORIZONTAL Y GRANDE
@Composable
fun PantallaListado(modifier: Modifier = Modifier) {

    //Lista de prueba para la parte de abajo (4 en 4)
    val listaSeriesRestantes = getDatosSerie()

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