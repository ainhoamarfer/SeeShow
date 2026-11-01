package pmdm.seeshow.ui.componente

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.unit.dp
import pmdm.seeshow.R

data class CabeceraSerieItemData(
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
        modifier = modifier.fillMaxWidth()
    ) {

        Icon(
            //TODO cambiar el check por el corazon, hacer componente por separado porque lo voy a usar mas veces
            painter = painterResource(id = R.drawable.check),
            contentDescription = "Guardar",
            tint = Color.White,
            modifier = Modifier.size(10.dp)
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
            Column(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = data.titulo,
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = data.fecha,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = data.creadaPor,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )


            }
        }
    }

    Text(
        text = data.descripcion,
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.onSurface,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )

}


