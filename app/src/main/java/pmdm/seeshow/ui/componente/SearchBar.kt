package pmdm.seeshow.ui.componente

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.compose.ui.tooling.preview.Preview
import pmdm.seeshow.R
import pmdm.seeshow.ui.theme.AppTypography
import pmdm.seeshow.ui.theme.BackgroundBlack
import pmdm.seeshow.ui.theme.Primary
import pmdm.seeshow.ui.theme.PrimaryDark
import pmdm.seeshow.ui.theme.SeeShowTheme
import pmdm.seeshow.ui.theme.SurfaceComponent
import pmdm.seeshow.ui.theme.TextWhite

data class DatosBarraBusqueda(
    val texto: String = "",
    val placeholder: String = "Buscar series...",
    val onValueChange: (String) -> Unit
)


@Composable
fun BarraBusqueda(
    data: DatosBarraBusqueda,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(52.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(SurfaceComponent)
            .border(
                width = 1.dp,
                color = TextWhite.copy(alpha = 0.15f),
                shape = RoundedCornerShape(4.dp)
            )
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        // icono

        Icon(
            painter = painterResource(id = R.drawable.lupa),
            contentDescription = "Buscar",
            tint = PrimaryDark,
            modifier = Modifier.size(20.dp)
        )

        //CAMPO TEXTO
        Box(
            modifier = Modifier.weight(1f)
        ) {

            BasicTextField(
                value = data.texto,
                onValueChange = data.onValueChange,
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                textStyle = AppTypography.bodyMedium.copy(
                    color = TextWhite
                ),
                cursorBrush = SolidColor(Primary)
            )

            // PLACEHOLDER
            if (data.texto.isEmpty()) {
                Text(
                    text = data.placeholder,
                    color = TextWhite.copy(alpha = 0.5f),
                    style = AppTypography.bodyMedium
                )
            }
        }

        // BOTÓN BORRAR
        if (data.texto.isNotEmpty()) {

            Icon(
                painter = painterResource(id = R.drawable.x),
                contentDescription = "Borrar",
                tint = TextWhite,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BarraBusquedaPreview() {

    SeeShowTheme {

        var texto by remember {
            mutableStateOf("")
        }

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .background(BackgroundBlack)
                .padding(16.dp),
            color = BackgroundBlack
        ) {

            BarraBusqueda(
                data = DatosBarraBusqueda(
                    texto = texto,
                    placeholder = "Buscar series...",
                    onValueChange = {
                        texto = it
                    }
                )
            )
        }
    }
}
