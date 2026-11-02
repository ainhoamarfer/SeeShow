package pmdm.seeshow.ui.componente

import android.view.Surface
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pmdm.seeshow.R
import pmdm.seeshow.ui.theme.SeeShowTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import pmdm.seeshow.ui.theme.AppTypography
import pmdm.seeshow.ui.theme.TextWhite


data class CabeceraSerieItemData(
    val id: Int,
    val titulo: String,
    val fecha: String,
    val creadaPor: String,
    val descripcion: String,
    val plataforma: String, //TODO CAMBIAR POR COMPONENTE
    val icono: Int,
    val imagen: Int
)

@Composable
fun CabeceraSerieItem(data: CabeceraSerieItemData, modifier: Modifier = Modifier) {

    Box(
        modifier = modifier.fillMaxWidth().height(220.dp) //TODO provisional
    ) {

        Icon(
            //TODO cambiar el check
            painter = painterResource(id = R.drawable.check),
            contentDescription = "Guardar",
            tint = TextWhite,
            modifier = Modifier.align(Alignment.TopEnd)
                .size(30.dp)
        )

        Row(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.width(150.dp)) {
                Image(
                    painter = painterResource(id = data.imagen),
                    contentDescription = data.titulo,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.fillMaxSize(),verticalArrangement = Arrangement.Bottom) {
                Text(
                    text = data.titulo,
                    style = AppTypography.headlineLarge,
                    color = TextWhite,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = data.fecha,
                    style = AppTypography.bodyMedium,
                    color = TextWhite,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = data.creadaPor,
                    style = AppTypography.bodySmall,
                    color = TextWhite,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }

    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = data.descripcion,
        style = AppTypography.bodySmall,
        color = TextWhite,
        overflow = TextOverflow.Ellipsis
    )

}

@Preview(
    showBackground = true,
    widthDp = 400
)
@Composable
fun PreviewCabeceraSerieItem() {
    SeeShowTheme {
        Surface() {
            Column(
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                CabeceraSerieItem(
                    data = CabeceraSerieItemData(
                        id = 1,
                        titulo = stringResource(R.string.titulo_serie_severance),
                        fecha = stringResource(R.string.fecha_severance),
                        creadaPor = stringResource(R.string.creada_por_seve),
                        descripcion = stringResource(R.string.descripcion_seve),
                        plataforma = stringResource(R.string.plataforma_seve),
                        icono = android.R.drawable.ic_menu_camera, // Placeholder
                        imagen = R.drawable.severance
                    )
                )
            }
        }
    }
}


