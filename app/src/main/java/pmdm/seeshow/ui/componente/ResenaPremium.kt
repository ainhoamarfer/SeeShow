package pmdm.seeshow.ui.componente

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pmdm.seeshow.R
import pmdm.seeshow.ui.theme.SeeShowTheme
import pmdm.seeshow.ui.theme.*



data class ResenaPremiumData(
    //val id: UUID, TODO 
    val resena: String,
    val autor: String
)


@Composable
fun ResenaPremium(data: ResenaPremiumData, modifier: Modifier = Modifier){

    Column(modifier = Modifier
        .fillMaxWidth()
        .background(SurfaceComponent)
        .drawBehind {
            val borderWidth = 4.dp.toPx() // Grosor del borde
            drawRect(
                color = Primary,
                topLeft = Offset(0f, 0f),
                size = Size(borderWidth, size.height)
            )
        }
        .padding(16.dp)
    ) {
        Text(
            text = data.resena,
            style = AppTypography.titleLarge,
            color = TextWhite
        )

        Spacer(modifier = Modifier.padding(4.dp))

        Text(
            text = data.autor,
            style = AppTypography.bodyMedium,
            color = TextWhite,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(
    showBackground = true,
    widthDp = 400
)
@Composable
fun PreviewResenaPremium() {
    SeeShowTheme {
        Surface() {
            Column(
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                ResenaPremium(
                    data = ResenaPremiumData(
                        resena = stringResource(R.string.resena_ejemplo),
                        autor = stringResource(R.string.resena_autor),
                    )
                )
            }
        }
    }
}