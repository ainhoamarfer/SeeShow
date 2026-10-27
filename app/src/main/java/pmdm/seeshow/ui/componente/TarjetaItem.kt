package pmdm.seeshow.ui.componente

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import pmdm.seeshow.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//primero se definenlos datos y luego lo visual

/**
 * datos de la tarjetaItem
 */
data class TarjetaItemData(
    val titulo: String,
    val descripcion: String,
    val onBorrar: () -> Unit,
    val onVerMas: () -> Unit,
)

@Composable
fun TarjetaItem(
    data: TarjetaItemData,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = data.titulo, style = MaterialTheme.typography.titleMedium)
            Text(
                text = data.descripcion,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 4.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedButton(onClick = data.onBorrar) {
                    Icon(painterResource(R.drawable.ic_delete), contentDescription = null)
                    Text("Borrar", modifier = Modifier.padding(start = 4.dp))
                }
                Button(
                    onClick = data.onVerMas,
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text("Ver más")
                }
            }
        }
    }
}

@Preview
@Composable
fun TarjetaItemPreview() {
    MaterialTheme() {
        TarjetaItem(
            data = TarjetaItemData(
                titulo = "Título de la tarjeta",
                descripcion = "Descripción de la tarjeta",
                onBorrar = {},
                onVerMas = {}
            )
        )
    }
}