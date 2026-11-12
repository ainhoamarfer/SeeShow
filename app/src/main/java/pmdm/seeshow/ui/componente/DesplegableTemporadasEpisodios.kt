package pmdm.seeshow.ui.componente

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pmdm.seeshow.seeder.obtenerEpisodiosPorTemporada
import pmdm.seeshow.ui.theme.*

// ui/componente/DesplegableTemporadasEpisodios.kt

data class DesplegableTemporadasEpisodiosData(
    val temporadas: List<String>,
    val episodiosPorTemporada: List<List<BotonEpisodioPuntuacionData>>,
    val desplegado: Boolean = true
)

@Composable
fun DesplegableTemporadasEpisodios(
    data: DesplegableTemporadasEpisodiosData,
    modifier: Modifier = Modifier
) {

    // 1. El componente recuerda su propio estado interno
    var menuAbierto by remember { mutableStateOf(false) }
    var temporadaSeleccionada by remember { mutableIntStateOf(0) }

    val episodiosAMostrar = data.episodiosPorTemporada.getOrNull(temporadaSeleccionada) ?: emptyList()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(SurfaceComponent)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Fila del DropDown
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.Right
        ) {
            BotonDropDown(
                data = BotonDropDownData(
                    temporadas = data.temporadas,
                    temporadaSeleccionada = temporadaSeleccionada,
                    desplegado = menuAbierto,
                    onToggle = { menuAbierto = !menuAbierto }, // Abre/cierra
                    onTemporadaClick = { index ->
                        temporadaSeleccionada = index // Cambia la temporada
                    }
                )
            )

        }

        // Fila con los botones de episodios (solo si desplegado)
        if (data.desplegado) {
            episodiosAMostrar.chunked(6).forEach { filaDeEpisodios ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Pintamos los episodios de esta fila
                    filaDeEpisodios.forEach { episodio ->
                        BotonEpisodioPuntuacion(
                            data = episodio,
                            modifier = Modifier.weight(1f)
                        )
                    }

                    // Relleno para que la última fila mantenga el tamaño si no está llena
                    repeat(6 - filaDeEpisodios.size) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }

            Text(
                text = "Toca uno para saltar al desglose del episodio",
                color = TextWhite.copy(alpha = 0.5f),
                style = AppTypography.labelSmall,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0C0E10)
@Composable
private fun DesplegableTemporadasEpisodiosPreview() {
    SeeShowTheme {
        DesplegableTemporadasEpisodios(
            data = DesplegableTemporadasEpisodiosData(
                temporadas = listOf("T1", "T2", "T3"),
                episodiosPorTemporada  = obtenerEpisodiosPorTemporada()
            )
        )
    }
}