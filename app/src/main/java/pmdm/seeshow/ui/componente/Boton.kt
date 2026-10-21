package pmdm.seeshow.ui.componente

import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pmdm.seeshow.ui.theme.SeeShowTheme

data class BotonItemData(
    val texto: String = "Click",
    val onClic: () -> Unit
)

@Composable
fun BotonItem(
    data: BotonItemData,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = data.onClic,
        modifier = modifier
    ) {
        Text(text = data.texto)
    }
}

@Preview(showBackground = true)
@Composable
fun BotonItemPreview() {
    SeeShowTheme {
        Surface {
            BotonItem(
                data = BotonItemData(
                    texto = "Click",
                    onClic = {}
                )
            )
        }
    }
}
