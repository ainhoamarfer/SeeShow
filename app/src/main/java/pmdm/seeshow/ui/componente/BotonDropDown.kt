package pmdm.seeshow.ui.componente

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pmdm.seeshow.ui.theme.*

data class BotonDropDownData(
    val temporadas: List<String>,
    val temporadaSeleccionada: Int,
    val desplegado: Boolean,
    val onToggle: () -> Unit,
    val onTemporadaClick: (Int) -> Unit
)

@Composable
fun BotonDropDown(
    data: BotonDropDownData,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        // Botón que muestra la temporada actual + flecha
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .background(SurfaceComponent)
                .clickable(onClick = data.onToggle)
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = data.temporadas[data.temporadaSeleccionada],
                color = TextWhite,
                style = AppTypography.labelLarge,
                fontWeight = FontWeight.Bold
            )
            Icon(
                imageVector = if (data.desplegado) Icons.Filled.KeyboardArrowUp
                else Icons.Filled.KeyboardArrowDown,
                contentDescription = "Desplegar temporadas",
                tint = Primary,
                modifier = Modifier.size(20.dp)
            )
        }

        // Menú desplegable
        DropdownMenu(
            expanded = data.desplegado,
            onDismissRequest = data.onToggle,
            containerColor = SurfaceComponent
        ) {
            data.temporadas.forEachIndexed { index, nombre ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = nombre,
                            color = if (index == data.temporadaSeleccionada) Primary else TextWhite,
                            style = AppTypography.labelLarge,
                            fontWeight = if (index == data.temporadaSeleccionada) FontWeight.Bold
                            else FontWeight.Normal
                        )
                    },
                    onClick = {
                        data.onTemporadaClick(index)
                        data.onToggle() // cierra el menú al elegir
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0C0E10)
@Composable
private fun BotonDropDownPreview() {
    SeeShowTheme {
        BotonDropDown(
            data = BotonDropDownData(
                temporadas = listOf("Temporada 1", "Temporada 2", "Temporada 3"),
                temporadaSeleccionada = 0,
                desplegado = false,
                onToggle = {},
                onTemporadaClick = {}
            )
        )
    }
}