package pmdm.seeshow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pmdm.seeshow.ui.componente.DatosSerieListadoCard
import pmdm.seeshow.ui.componente.SerieListadoCard
import pmdm.seeshow.ui.componente.TipoSerieCard
import pmdm.seeshow.ui.theme.SeeShowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SeeShowTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {

                        //TODO hacer Scaffold
                    }
                )
                { innerPadding ->
                    PantallaListado(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

//TODO HACER LAS MODIFICACIONES DE CARDS HORIZONTAL Y GRANDE
@Composable
fun PantallaListado(modifier: Modifier = Modifier) {

    //Lista de prueba para la parte de abajo (4 en 4)
    val listaSeriesRestantes = listOf(
        DatosSerieListadoCard(
            recursoImagen = R.drawable.succesion,
            titulo = "The Office",
            subtitulo = "T9 · 201 Caps",
            puntuacion = "4.8",
            porcentajeCompletada = "90%",
            tipo = TipoSerieCard.VERTICAL
        ),
        DatosSerieListadoCard(
            recursoImagen = R.drawable.succesion,
            titulo = "Narcos",
            subtitulo = "T3 · 30 Caps",
            puntuacion = "4.7",
            porcentajeCompletada = "50%",
            tipo = TipoSerieCard.VERTICAL
        ),
        DatosSerieListadoCard(
            recursoImagen = R.drawable.succesion,
            titulo = "Friends",
            subtitulo = "T10 · 236 Caps",
            puntuacion = "4.9",
            porcentajeCompletada = "100%",
            tipo = TipoSerieCard.VERTICAL
        ),
        DatosSerieListadoCard(
            recursoImagen = R.drawable.succesion,
            titulo = "Breaking Bad",
            subtitulo = "T5 · 62 Caps",
            puntuacion = "4.9",
            porcentajeCompletada = "80%",
            tipo = TipoSerieCard.VERTICAL
        ),
        DatosSerieListadoCard(
            recursoImagen = R.drawable.succesion,
            titulo = "Friends",
            subtitulo = "T10 · 236 Caps",
            puntuacion = "4.9",
            porcentajeCompletada = "100%",
            tipo = TipoSerieCard.VERTICAL
        ),
        DatosSerieListadoCard(
            recursoImagen = R.drawable.succesion,
            titulo = "Friends",
            subtitulo = "T10 · 236 Caps",
            puntuacion = "4.9",
            porcentajeCompletada = "100%",
            tipo = TipoSerieCard.VERTICAL
        ),
        DatosSerieListadoCard(
            recursoImagen = R.drawable.succesion,
            titulo = "Friends",
            subtitulo = "T10 · 236 Caps",
            puntuacion = "4.9",
            porcentajeCompletada = "100%",
            tipo = TipoSerieCard.VERTICAL
        ),
        DatosSerieListadoCard(
            recursoImagen = R.drawable.succesion,
            titulo = "Friends",
            subtitulo = "T10 · 236 Caps",
            puntuacion = "4.9",
            porcentajeCompletada = "100%",
            tipo = TipoSerieCard.VERTICAL
        ),
        DatosSerieListadoCard(
            recursoImagen = R.drawable.succesion,
            titulo = "Friends",
            subtitulo = "T10 · 236 Caps",
            puntuacion = "4.9",
            porcentajeCompletada = "100%",
            tipo = TipoSerieCard.VERTICAL
        ),
        DatosSerieListadoCard(
            recursoImagen = R.drawable.succesion,
            titulo = "Friends",
            subtitulo = "T10 · 236 Caps",
            puntuacion = "4.9",
            porcentajeCompletada = "100%",
            tipo = TipoSerieCard.VERTICAL
        ),
        DatosSerieListadoCard(
            recursoImagen = R.drawable.succesion,
            titulo = "Friends",
            subtitulo = "T10 · 236 Caps",
            puntuacion = "4.9",
            porcentajeCompletada = "100%",
            tipo = TipoSerieCard.VERTICAL
        ),
        DatosSerieListadoCard(
            recursoImagen = R.drawable.succesion,
            titulo = "Friends",
            subtitulo = "T10 · 236 Caps",
            puntuacion = "4.9",
            porcentajeCompletada = "100%",
            tipo = TipoSerieCard.VERTICAL
        ),
        DatosSerieListadoCard(
            recursoImagen = R.drawable.succesion,
            titulo = "Friends",
            subtitulo = "T10 · 236 Caps",
            puntuacion = "4.9",
            porcentajeCompletada = "100%",
            tipo = TipoSerieCard.VERTICAL
        ),
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
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