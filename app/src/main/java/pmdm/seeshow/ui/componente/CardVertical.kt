package pmdm.seeshow.ui.componente

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pmdm.seeshow.R
import pmdm.seeshow.ui.theme.SeeShowTheme

data class CardVerticalData(
    val titulo: String = "Titulo",
    val descripcion: String = "Descripción"
)
@Composable
fun CardVerticalItem (data: CardVerticalData, modifier: Modifier = Modifier){
    Card(
        modifier = modifier
        //añadir imagen
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
        )
        Row(modifier = Modifier) {
            Text(text = data.titulo)
            Text(text = data.descripcion)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CardVerticalPreview() {
    SeeShowTheme {
        Surface {
            CardVerticalItem(
                data = CardVerticalData(
                    titulo = "Severance",
                    descripcion = "Descripción",
                )
            )
        }
    }
}