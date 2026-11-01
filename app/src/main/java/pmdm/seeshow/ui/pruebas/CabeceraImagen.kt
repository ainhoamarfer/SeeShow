package pmdm.seeshow.ui.pruebas

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pmdm.seeshow.R


data class CabeceraImagenData(
    @DrawableRes val imagen: Int,
    val onIconoIzquierdo: () -> Unit,
    val onIconoDerecho: () -> Unit
)

@Composable
fun CabeceraImagen(data: CabeceraImagenData, modifier: Modifier = Modifier){
    Box(modifier = modifier
        .fillMaxWidth()
        .height(200.dp)){
        Image(
            painter = painterResource(data.imagen),
            contentDescription = stringResource(R.string.imagen_de_cabecera),
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        IconButton(onClick = data.onIconoIzquierdo,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(8.dp))  {

            Icon(painter = painterResource(R.drawable.ic_favorite),
                contentDescription = stringResource(R.string.favorito),
                tint = Color.White
            )
        }

        IconButton(onClick = data.onIconoDerecho,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp))  {

            Icon(painter = painterResource(R.drawable.ic_share),
                contentDescription = stringResource(R.string.favorito),
                tint = Color.White
            )
        }
    }


}

@Preview
@Composable
fun CabeceraImagenPreview(){
    MaterialTheme() {
        CabeceraImagen(
            data = CabeceraImagenData(
                imagen = R.drawable.cabecera,
                onIconoIzquierdo = {},
                onIconoDerecho = {}
            )
        )
    }
}