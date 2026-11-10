package pmdm.seeshow.ui.componente

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import pmdm.seeshow.R
import pmdm.seeshow.ui.theme.AppTypography
import pmdm.seeshow.ui.theme.BackgroundBlack
import pmdm.seeshow.ui.theme.Secondary
import pmdm.seeshow.ui.theme.SecondaryDark
import pmdm.seeshow.ui.theme.TextWhite

data class BotonTSDesplegableData(
    val id: Int,
    val puntuacion: String,
    val episodio: String,
    val punto: Int,
    val onClic: () -> Unit
)

@Composable
fun BotonTSDesplegable(data: BotonTSDesplegableData, modifier: Modifier = Modifier) {

    Button(
        onClick = data.onClic,
        modifier = modifier,
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = BackgroundBlack,
            contentColor = TextWhite
        ),
        contentPadding = ButtonDefaults.ContentPadding
    ) {

        Column(modifier = modifier.fillMaxWidth()) {
            Text(
                text = data.puntuacion,
                style = AppTypography.labelSmall,
                color = Secondary,
                maxLines = 1
            )

            Icon(
                painter = painterResource(id = R.drawable.eye),
                contentDescription = "Episodio y su puntuacion",
                tint = SecondaryDark,
                modifier = Modifier.size(20.dp)
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = data.episodio,
                style = AppTypography.labelSmall,
                color = TextWhite,
                maxLines = 1
            )
        }
    }
}