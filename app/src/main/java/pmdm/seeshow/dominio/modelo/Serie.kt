package pmdm.seeshow.dominio.modelo

import java.util.UUID

data class Serie(
    val id: Int,
    val titulo: String,
    val imagenPoster: String,
    val imagenFondo: String,
    val fechaInicio: String,
    val creadaPor: String,
    val dirigidaPor: String,
    val descripcion: String,
    val plataforma: String,
    val plataformaOriginal: Boolean,
    val puntuacion: Double,
    val porcentajeCompletada: Int,
    val numeroTemporadas: Int,
    val numeroCapitulos: Int,
    val resenaPremium: Resena? = null,
    val reparto: List<Actor> = emptyList(),
    val seriesRelacionadas: List<Serie> = emptyList()
)

data class Resena(
    val texto: String,
    val autor: String
)

data class Actor(
    val id: Int,
    val nombre: String,
    val personaje: String,
    val imagen: String
)
