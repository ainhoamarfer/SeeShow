package pmdm.seeshow.seeder

import pmdm.seeshow.ui.componente.BotonEpisodioPuntuacionData

fun obtenerEpisodiosPorTemporada(): List<List<BotonEpisodioPuntuacionData>> {
    return listOf(
        // Índice 0 -> TEMPORADA 1
        listOf(
            BotonEpisodioPuntuacionData(id = 1, puntuacion = "8.8", episodio = "E01", onClic = {}),
            BotonEpisodioPuntuacionData(id = 2, puntuacion = "8.8", episodio = "E02", onClic = {}),
            BotonEpisodioPuntuacionData(id = 3, puntuacion = "8.8", episodio = "E03", onClic = {}),
            BotonEpisodioPuntuacionData(id = 4, puntuacion = "8.8", episodio = "E04", onClic = {}),
            BotonEpisodioPuntuacionData(id = 5, puntuacion = "2.5", episodio = "E05", onClic = {}),
            BotonEpisodioPuntuacionData(id = 6, puntuacion = "8.8", episodio = "E06", onClic = {}),
            BotonEpisodioPuntuacionData(id = 7, puntuacion = "8.8", episodio = "E07", onClic = {}),
            BotonEpisodioPuntuacionData(id = 8, puntuacion = "8.8", episodio = "E08", onClic = {}),
            BotonEpisodioPuntuacionData(id = 9, puntuacion = "8.8", episodio = "E09", onClic = {})
        ),
        // Índice 1 -> TEMPORADA 2
        listOf(
            BotonEpisodioPuntuacionData(id = 10, puntuacion = "7.5", episodio = "E01", onClic = {}),
            BotonEpisodioPuntuacionData(id = 11, puntuacion = "8.1", episodio = "E02", onClic = {}),
            BotonEpisodioPuntuacionData(id = 12, puntuacion = "9.0", episodio = "E03", onClic = {})
        ),
        // Índice 2 -> TEMPORADA 3
        listOf(
            BotonEpisodioPuntuacionData(id = 13, puntuacion = "9.5", episodio = "E01", onClic = {}),
            BotonEpisodioPuntuacionData(id = 14, puntuacion = "9.8", episodio = "E02", onClic = {})
        )
    )
}