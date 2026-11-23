package pmdm.seeshow.ui.pagina

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import pmdm.seeshow.R
import pmdm.seeshow.seeder.obtenerEpisodiosPorTemporada
import pmdm.seeshow.ui.componente.*
import pmdm.seeshow.ui.theme.SeeShowTheme
import pmdm.seeshow.ui.theme.TextWhite
import pmdm.seeshow.ui.viewmodel.PantallaDetalleVM

@Composable
fun PantallaDetalle(
    serieId: Int,
    onGoBack: () -> Unit,
    vm: PantallaDetalleVM = viewModel()
) {

    val uiState by vm.uiState.collectAsState()

    LaunchedEffect(serieId) {
        vm.load(serieId)
    }

    val serie = uiState.serie

    if (serie == null) {

        Column(

        ) {
            Text("Cargando serie...")
        }

    } else {

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(
                bottom = 80.dp
            )
        ) {

            // Flecha para volver
            item {
                IconButton(
                    onClick = { onGoBack() },
                    modifier = Modifier
                        .padding(10.dp)
                        .size(30.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_left),
                        contentDescription = "Volver",
                        tint = TextWhite
                    )
                }
            }


            item {
                CabeceraSerieItem(
                    data = CabeceraSerieItemData(
                        id = uiState.serie!!.id,
                        titulo = uiState.serie!!.titulo,
                        fecha = uiState.serie!!.fechaInicio,
                        creadaPor = uiState.serie!!.creadaPor,
                        descripcion = uiState.serie!!.descripcion,
                        plataforma = uiState.serie!!.plataformas.joinToString(", "),
                        icono = android.R.drawable.ic_menu_camera,
                        imagen = uiState.serie!!.imagenPoster,
                        imagenFondo = uiState.serie!!.imagenFondo
                    )
                )
            }

            item {
                ResenaPremium(
                    data = ResenaPremiumData(
                        resena = stringResource(R.string.resena_ejemplo),
                        autor = stringResource(R.string.resena_autor)
                    )
                )
            }

            //Botonera
            //Row(
            //    modifier = Modifier.fillMaxWidth(),
            //    horizontalArrangement = Arrangement.spacedBy(12.dp)
            //) {
            //    Botones(
            //        enum = VarianteBoton.BASICO_INACTIVO,
            //        data = BotonData(
            //            id = uiState.serie!!.id,
            //            texto = stringResource(R.string.boton_temporada_capitulos),
            //            onClic = {}
            //        )
            //    )
            //    Botones(
            //        enum = VarianteBoton.BASICO_INACTIVO,
            //        data = BotonData(
            //            id = uiState.serie!!.id,
            //            texto = "Reparto",
            //            onClic = {}
            //        )
            //    )
//
            //    Botones(
            //        enum = VarianteBoton.BASICO_INACTIVO,
            //        data = BotonData(
            //            id = uiState.serie!!.id,
            //            texto = "Reseñas",
            //            onClic = {}
            //        )
            //    )
            //}

            item {
                DesplegableTemporadasEpisodios(
                    data = DesplegableTemporadasEpisodiosData(
                        temporadas = listOf("T1", "T2", "T3"),
                        episodiosPorTemporada = obtenerEpisodiosPorTemporada()
                    )
                )
            }

            //Reparto
            item {
                TituloSeccion(
                    datos = TituloSeccionData(
                        tituloSeccion = "Reparto",
                        textoBotonDerecha = "Ver todo",
                        onClick = {}
                    )
                )
            }

            item {
                val actores = uiState.actores

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    items(actores) { actor ->
                        SerieListadoCard(
                            datos = actor
                        )
                    }
                }
            }

            //Relacionados
            item {
                TituloSeccion(
                    datos = TituloSeccionData(
                        tituloSeccion = "También te puede gustar",
                        textoBotonDerecha = "Ver todo",
                        onClick = {}
                    )
                )
            }

            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    items(uiState.seriesRelacionadas) { serie ->
                        SerieListadoCard(
                            datos = DatosSerieListadoCard(
                                id = serie.id,
                                recursoImagen = serie.imagenPoster,
                                titulo = serie.titulo,
                                subtitulo = serie.creadaPor,
                                puntuacion = serie.puntuacion.toString(),
                                tipo = TipoSerieCard.VERTICAL
                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaDetallePreview() {
    SeeShowTheme {
        Surface {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                PantallaDetalle(
                    serieId = 1,
                    onGoBack = {}
                )
            }

        }
    }
}