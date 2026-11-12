package pmdm.seeshow.ui.componente

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import pmdm.seeshow.R
import pmdm.seeshow.ui.theme.AppTypography
import pmdm.seeshow.ui.theme.BackgroundBlack
import pmdm.seeshow.ui.theme.Secondary
import pmdm.seeshow.ui.theme.SecondaryDark
import pmdm.seeshow.ui.theme.SurfaceComponent
import pmdm.seeshow.ui.theme.TextWhite

data class BotonEpisodioPuntuacionData(
    val id: Int,
    val puntuacion: String,
    val episodio: String,
    val onClic: () -> Unit
)

@Composable
fun BotonEpisodioPuntuacion(
    data: BotonEpisodioPuntuacionData,
    modifier: Modifier = Modifier,
    seleccionado: Boolean = false
) {
    val colorBorde = if (seleccionado) TextWhite else Color(0xFF333333)
    val grosorBorde = if (seleccionado) 1.5.dp else 1.dp

    Button(
        onClick = data.onClic,
        modifier = modifier.border(
            border = BorderStroke(grosorBorde, colorBorde),
            shape = RoundedCornerShape(4.dp)
        ),
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = BackgroundBlack,   // fondo del botón
            contentColor = TextWhite
        ),
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = data.puntuacion,
                style = AppTypography.labelSmall,
                color = Secondary,
                maxLines = 1
            )

            // Punto separador
            Box(
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .size(6.dp)
                    .background(
                        color = SecondaryDark,
                        shape = CircleShape
                    )
            )

            Text(
                text = data.episodio,
                style = AppTypography.labelSmall,
                color = TextWhite,
                maxLines = 1
            )
        }
    }
}