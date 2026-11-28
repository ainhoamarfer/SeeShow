package pmdm.seeshow.ui.componente

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pmdm.seeshow.ui.theme.AppTypography
import pmdm.seeshow.ui.theme.Primary
import pmdm.seeshow.ui.theme.SeeShowTheme
import pmdm.seeshow.ui.theme.TextWhite
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.Alignment

data class TituloSeccionData(
    val tituloSeccion: String,
    val textoBotonDerecha: String,
    val onClick: () -> Unit
)

@Composable
fun TituloSeccion(
    datos: TituloSeccionData,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            datos.tituloSeccion,
            style = AppTypography.titleMedium,
            color = TextWhite,
            maxLines = 1
        )

        TextButton(
            onClick = datos.onClick,
            modifier = modifier,
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color.Transparent,
                contentColor = TextWhite
            ),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(text =
                datos.textoBotonDerecha,
                style = AppTypography.labelMedium,
                color = Primary,
                maxLines = 1)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TituloSeccionPreview() {
    SeeShowTheme {
        TituloSeccion(
            datos = TituloSeccionData(
                tituloSeccion = "Reparto",
                textoBotonDerecha = "Ver todo",
                onClick = {}
            )
        )
    }
}