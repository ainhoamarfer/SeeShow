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
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pmdm.seeshow.R
import pmdm.seeshow.ui.theme.Primary


data class BotonData(
    val id: Int,
    val texto: String,
    val variante: VarianteBoton,
    val icono: Int? = null //poder elegir si poner el icono o no, int por el id que esta en el drawable
)

enum class VarianteBoton {
    BASICO_ACTIVO,
    BASICO_INACTIVO,
    VER,
    VISTO
}

//TODO hacer un componente por cada boton
@Composable
fun Botones(enum: VarianteBoton){

    if(enum == VarianteBoton.BASICO_ACTIVO){

    }
    if(enum == VarianteBoton.BASICO_INACTIVO){

    }
    if(enum == VarianteBoton.VER){

    }
    if(enum == VarianteBoton.VISTO){

    }

}

@Composable
fun BotonComp(
    datos: BotonData,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val colorFondo = when (datos.variante) {
        VarianteBoton.BASICO_ACTIVO -> Primary //TODO CAMBIAR COLORES
        VarianteBoton.BASICO_INACTIVO -> Color(0xFF15191B)
        VarianteBoton.VISTO -> Color(0xFF292D30)
        VarianteBoton.VER -> Color.Transparent
    }

    val colorTexto = when (datos.variante) {
        VarianteBoton.BASICO_ACTIVO -> Color.White
        VarianteBoton.BASICO_INACTIVO -> Color.White
        VarianteBoton.VISTO -> Color.White
        VarianteBoton.VER -> Color.White
    }

    val esBotonSinIcono = datos.variante == VarianteBoton.VER
    val esBtnConIcono = datos.variante == VarianteBoton.BASICO_ACTIVO

    //componente contenido
    val contenido: @Composable () -> Unit = {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            datos.icono?.let { icono ->
                Image(
                    painter = painterResource(id = icono),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
            }

            Text(text = datos.texto)
        }
    }

    if (esBotonSinIcono) {
        TextButton(
            onClick = onClick,
            modifier = modifier,
            colors = ButtonDefaults.textButtonColors(contentColor = colorTexto)
        ) {
            contenido()
        }
    } else {
        Button(
            onClick = onClick,
            modifier = modifier,
            shape = RoundedCornerShape( 4.dp
            ),

            colors = ButtonDefaults.buttonColors(
                containerColor = colorFondo,
                contentColor = colorTexto
            ),

            contentPadding = ButtonDefaults.ContentPadding,
        ) {
            contenido()
        }
    }
}

    @Preview
    @Composable
    fun BotonPreview(){
        MaterialTheme() {

            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)) {

                val botonT1 = BotonData(
                    id = 1,
                    texto = stringResource(R.string.boton_temporada_capitulos),
                    variante = VarianteBoton.BASICO_ACTIVO
                )
                BotonComp(
                    datos = botonT1,
                    onClick = {}
                )

                val botonT2 = BotonData(
                    id = 2,
                    texto = stringResource(R.string.boton_temporada_capitulos),
                    variante = VarianteBoton.BASICO_INACTIVO
                )
                BotonComp(
                    datos = botonT2,
                    onClick = {}
                )

                val botonVisto = BotonData(
                    id = 3,
                    texto = stringResource(R.string.boton_visto),
                    variante = VarianteBoton.VISTO,
                    icono = R.drawable.check
                )
                BotonComp(
                    datos = botonVisto,
                    onClick = {},
                )

                val botonVerTodo = BotonData(
                    id = 4,
                    texto = stringResource(R.string.boton_marcar_como_visto),
                    variante = VarianteBoton.VER,
                    icono = R.drawable.eye
                )
                BotonComp(
                    datos = botonVerTodo,
                    onClick = {},
                )
            }

        }
    }



