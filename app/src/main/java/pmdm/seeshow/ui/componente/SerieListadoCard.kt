package pmdm.seeshow.ui.componente

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pmdm.seeshow.ui.theme.SeeShowTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import pmdm.seeshow.R
import pmdm.seeshow.ui.theme.BackgroundBlack

//Variantes
enum class TipoSerieCard(
    val ancho: Dp,
    val altoImagen: Dp
) {
    VERTICAL(ancho = 110.dp, altoImagen = 165.dp),
    VERTICAL_GRANDE(ancho = 150.dp, altoImagen = 225.dp),
    HORIZONTAL(ancho = 160.dp, altoImagen = 90.dp)
}
//Datos comunes en todas
data class DatosSerieListadoCard(
    val id: Int,
    val recursoImagen: Int,
    val titulo: String,
    val subtitulo: String,
    val puntuacion: String,
    val tipo: TipoSerieCard = TipoSerieCard.VERTICAL
)

@Composable
fun SerieListadoCard(
    datos: DatosSerieListadoCard,
    onCardClick: (Int) -> Unit = {},
    modifier: Modifier = Modifier
) {

    Card(
        onClick = {
            onCardClick(datos.id)
        },
        modifier = modifier.width(datos.tipo.ancho).fillMaxWidth(),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(datos.tipo.altoImagen)
                    .clip(RoundedCornerShape(4.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Image(
                    painter = painterResource(id = datos.recursoImagen),
                    contentDescription = datos.titulo,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                //Puntuación arriba derecha
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(4.dp)
                        .align(Alignment.TopEnd)
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .padding(horizontal = 4.dp, vertical = 0.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.star_rellena),
                        contentDescription = "Puntuación",
                        tint = Color.White,
                        modifier = Modifier.size(10.dp)
                    )

                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = datos.puntuacion,
                        color = Color.White,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            //TEXTOS DEBAJO DE LA IMAGEN
            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = datos.titulo,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,

            )

            Text(
                text = datos.subtitulo,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                maxLines = 1
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSerieCardVer() {
    SeeShowTheme {
        Surface() {
            SerieListadoCard(
                datos = DatosSerieListadoCard(
                    id = 1,
                    recursoImagen = R.drawable.succesion,
                    titulo = stringResource(R.string.titulo_serie_succession),
                    subtitulo = stringResource(R.string.temporada_capitulos),
                    puntuacion = stringResource(R.string.puntuacion),
                    tipo = TipoSerieCard.VERTICAL
                ),
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

