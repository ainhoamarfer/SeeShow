package pmdm.seeshow.dominio.modelo

import java.util.UUID

data class Serie(
    val id: String,
    val imagen: String,
    val nombre: String,
    val seriesRelacionadas: List<Serie>
    //TODO poner el resto
)