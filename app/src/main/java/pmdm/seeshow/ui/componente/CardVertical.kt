package pmdm.seeshow.ui.componente

import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pmdm.seeshow.ui.theme.SeeShowTheme

data class CardVerticalData(
    val titulo: String = "Titulo",
    val descripcion: String = "Descripción"
)

fun CardVerticalItem (data: CardVerticalData, modifier: Modifier){
    Card(
        modifier = modifier
        //añadir imagen
    ) {
        Text(text = data.titulo)
    }
}

@Preview(showBackground = true)
@Composable
fun CardVerticalPreview() {
    SeeShowTheme {
        Surface {
            CardVerticalItem(
                data = CardVerticalData(
                    texto = "Severance",
                    descripcion = "Descripción",
                )

            )
        }
    }
}