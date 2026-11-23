package pmdm.seeshow.ui.pagina


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import pmdm.seeshow.ui.componente.BarraBusqueda
import pmdm.seeshow.ui.componente.DatosBarraBusqueda
import pmdm.seeshow.ui.componente.SerieListadoCard
import pmdm.seeshow.ui.componente.TipoSerieCard
import pmdm.seeshow.ui.theme.BackgroundBlack
import pmdm.seeshow.ui.theme.SeeShowTheme
import pmdm.seeshow.ui.viewmodel.PantallaListadoVM

//TODO HACER LAS MODIFICACIONES DE CARDS HORIZONTAL Y GRANDE
@Composable
fun PantallaListado(
    onCardClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: PantallaListadoVM = viewModel()
) {

    //CARGAMOS ESTADO
    val uiState by viewModel.uiState.collectAsState()

    //la funcion load del viewModel siempre tiene que estas rodeado por el LaunchedEffect, para que no se recarguen todos los datos al cambiar de estado
    LaunchedEffect(Unit) {
        viewModel.cargarSeries()
    }

    //Lista de prueba para la parte de abajo (4 en 4)
    //val listaSeriesRestantes = datosSerie()

    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = modifier.fillMaxSize(),
        //contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        // BARRA DE BÚSQUEDA
        item(span = { GridItemSpan(4) }) {
            BarraBusqueda(
                data = DatosBarraBusqueda(
                    texto = uiState.searchText,
                    placeholder = "Buscar series...",
                    onValueChange = {
                        viewModel.onSearchTextChange(it)
                    }
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }

        //ILA DE ARRIBA, EL SPAN PARA QUE OCUPE 4 HUECOS
        if (uiState.listaSeries.size >= 3) {
            item(
                span = { GridItemSpan(4) }
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    //columna izquierda: Tarjeta grande
                    Box(modifier = Modifier.weight(1f)) {

                        val serieGrande = uiState.listaSeries[0]

                        SerieListadoCard(
                            datos = serieGrande.aDatosSerieListadoCard(
                                TipoSerieCard.VERTICAL_GRANDE
                            ),
                            onCardClick = onCardClick
                        )
                    }

                    //columna derecha: dos horizontales
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        val serieHorizontal1 = uiState.listaSeries[1]

                        SerieListadoCard(
                            datos = serieHorizontal1.aDatosSerieListadoCard(
                                TipoSerieCard.HORIZONTAL
                            ),
                            onCardClick = onCardClick
                        )

                        val serieHorizontal2 = uiState.listaSeries[2]

                        SerieListadoCard(
                            datos = serieHorizontal2.aDatosSerieListadoCard(
                                TipoSerieCard.HORIZONTAL
                            ),
                            onCardClick = onCardClick
                        )
                    }
                }
            }
        }

        val inicio = if (uiState.listaSeries.size >= 3) 3 else 0 //no usar las tres primeras
        //RESTO DE LA LISTA
        items(uiState.listaSeries.size - inicio) { index ->
            val current = uiState.listaSeries[index]

            SerieListadoCard(
                datos = current.aDatosSerieListadoCard(
                    TipoSerieCard.VERTICAL
                ),
                modifier = Modifier.fillMaxWidth(),
                onCardClick = onCardClick
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SeeShowTheme {
        Surface (modifier = Modifier
            .fillMaxWidth()
            .background(BackgroundBlack)
            .padding(16.dp),
            color = BackgroundBlack){
            PantallaListado(
                onCardClick = {},
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}