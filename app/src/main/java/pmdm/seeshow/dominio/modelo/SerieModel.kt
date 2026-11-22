package pmdm.seeshow.dominio.modelo

import androidx.annotation.DrawableRes
import pmdm.seeshow.ui.componente.DatosSerieListadoCard
import pmdm.seeshow.ui.componente.TipoSerieCard

data class Serie(
    val id: Int,
    val titulo: String,
    @DrawableRes val imagenPoster: Int,
    @DrawableRes val imagenFondo: Int,
    val fechaInicio: String,
    val creadaPor: String,
    val dirigidaPor: String,
    val descripcion: String,
    val plataformas: List<String>,
    val puntuacion: Double,
    //val porcentajeCompletada: Int,
    val numeroTemporadas: Int,
    val numeroCapitulos: Int,
    val resenaPremium: Resena? = null,
    val reparto: List<Actor> = emptyList(),
    val seriesRelacionadasIds: List<String> = emptyList() //evitamos tener series anidadas
) {
    fun aDatosSerieListadoCard(orientation: TipoSerieCard): DatosSerieListadoCard {
        return DatosSerieListadoCard(
            id = id,
            recursoImagen = imagenPoster,
            titulo = titulo,
            subtitulo = "T$numeroTemporadas · $numeroCapitulos Caps",
            puntuacion = puntuacion.toString(),
            tipo = orientation
        )
    }
}

