package pmdm.seeshow.ui.componente

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.triStateToggleable
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pmdm.seeshow.R
import pmdm.seeshow.ui.pagina.PantallaDetalle
import pmdm.seeshow.ui.theme.*
import pmdm.seeshow.ui.theme.AppTypography


data class BotonData(
    val id: Int,
    val texto: String,
    val onClic: () -> Unit,
    val icono: Int? = null
)

enum class VarianteBoton {
    BASICO_ACTIVO,
    BASICO_INACTIVO,
    MARCAR_COMO_VISTO,
    VISTO
}
@Composable
fun Botones(enum: VarianteBoton, data: BotonData, modifier: Modifier = Modifier){

    if(enum == VarianteBoton.BASICO_ACTIVO){
        TextButton(
            onClick = data.onClic,
            modifier = modifier,
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.textButtonColors(
                containerColor = Primary,
                contentColor = TextWhite
            ),
            contentPadding = ButtonDefaults.ContentPadding
        ) {
            Text(text =
                data.texto,
                style = AppTypography.labelMedium,
                color = TextWhite,
                maxLines = 1)
        }
    }
    if(enum == VarianteBoton.BASICO_INACTIVO){
        TextButton(
            onClick = data.onClic,
            modifier = modifier,
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.textButtonColors(
                containerColor = SurfaceComponent,
                contentColor = TextWhite
            ),
            contentPadding = ButtonDefaults.ContentPadding
        ) {
            Text(text =
                data.texto,
                style = AppTypography.labelMedium,
                color = TextWhite,
                maxLines = 1)
        }
    }
    if(enum == VarianteBoton.MARCAR_COMO_VISTO){
        Button(
            onClick = data.onClic,
            modifier = modifier,
            shape = RoundedCornerShape( 4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = BackgroundBlack,
                contentColor = TextWhite
            ),
            contentPadding = ButtonDefaults.ContentPadding
        ) {
            Icon(
                painter = painterResource(id = R.drawable.eye),
                contentDescription = "Marcar como visto",
                tint = TextWhite,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(text =
                data.texto,
                style = AppTypography.labelSmall,
                color = TextWhite,
                maxLines = 1)
        }

    }
    if(enum == VarianteBoton.VISTO){
        Button(
            onClick = data.onClic,
            modifier = modifier,
            shape = RoundedCornerShape( 4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = SurfaceComponent,
                contentColor = TextWhite
            ),
            contentPadding = ButtonDefaults.ContentPadding
        ) {
            Icon(
                painter = painterResource(id = R.drawable.check),
                contentDescription = "Visto",
                tint = TextWhite,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(text =
                data.texto,
                style = AppTypography.labelSmall,
                color = TextWhite,
                maxLines = 1)
        }
    }

}

data class BotonItem(
    val variante: VarianteBoton,
    val data: BotonData
)

    @Preview
    @Composable
    fun BotonPreview(){
        SeeShowTheme {
            Surface {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)) {

                    Botones(
                        enum = VarianteBoton.BASICO_ACTIVO,
                        data = BotonData(
                            id = 1,
                            texto = stringResource(R.string.boton_temporada_capitulos),
                            onClic = {}
                        )
                    )
                    Botones(
                        enum = VarianteBoton.BASICO_INACTIVO,
                        data = BotonData(
                            id = 1,
                            texto = stringResource(R.string.boton_temporada_capitulos),
                            onClic = {}
                        )
                    )
                    Botones(
                        enum = VarianteBoton.MARCAR_COMO_VISTO,
                        data = BotonData(
                            id = 1,
                            texto = stringResource(R.string.boton_marcar_como_visto),
                            onClic = {},
                            icono = R.drawable.eye
                        )
                    )
                    Botones(
                        enum = VarianteBoton.VISTO,
                        data = BotonData(
                            id = 1,
                            texto = stringResource(R.string.boton_visto),
                            onClic = {},
                            icono = R.drawable.eye
                        )
                    )
                }

            }
        }

    }



