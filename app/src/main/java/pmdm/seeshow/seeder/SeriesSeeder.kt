package pmdm.seeshow.seeder

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pmdm.seeshow.R
import pmdm.seeshow.dominio.modelo.Actor
import pmdm.seeshow.dominio.modelo.Resena
import pmdm.seeshow.dominio.modelo.Serie
import pmdm.seeshow.ui.componente.TipoSerieCard
import kotlin.Double


    fun listaSeries(): List<Serie> {

        val succession = Serie(
            id = 1,
            titulo = "Succession",
            imagenPoster = R.drawable.succesion,
            imagenFondo = R.drawable.imagen_cabecera_severance,
            fechaInicio = "2018-06-03",
            creadaPor = "Jesse Armstrong",
            dirigidaPor = "Mark Mylod",
            descripcion = "La familia Roy, propietaria de uno de los mayores conglomerados de medios de comunicación y entretenimiento del mundo, lucha por mantener el control de su imperio empresarial.",
            plataformas = listOf("Max"),
            puntuacion = 8.9,
            numeroTemporadas = 4,
            numeroCapitulos = 39,
            resenaPremium = Resena(
                texto = "Una de las mejores sátiras sobre el poder, el dinero y las relaciones familiares. Su guion y sus interpretaciones son extraordinarios.",
                autor = "SeeShow"
            ),
            reparto = listOf(
                Actor(1, "Brian Cox", "Logan Roy", R.drawable.britt_lower),
                Actor(2, "Jeremy Strong", "Kendall Roy", R.drawable.britt_lower),
                Actor(3, "Sarah Snook", "Shiv Roy", R.drawable.britt_lower),
                Actor(4, "Kieran Culkin", "Roman Roy", R.drawable.britt_lower),
                Actor(5, "Matthew Macfadyen", "Tom Wambsgans", R.drawable.britt_lower)
            )
        )

        val theOffice = Serie(
            id = 2,
            titulo = "The Office",
            imagenPoster = R.drawable.succesion,
            imagenFondo = R.drawable.imagen_cabecera_severance,
            fechaInicio = "2005-03-24",
            creadaPor = "Greg Daniels",
            dirigidaPor = "Ken Kwapis",
            descripcion = "Una divertida comedia que sigue el día a día de los empleados de una empresa papelera en Scranton, Pensilvania, donde las situaciones absurdas nunca faltan.",
            plataformas = listOf("Netflix"),
            puntuacion = 9.0,
            numeroTemporadas = 9,
            numeroCapitulos = 201,
            resenaPremium = Resena(
                texto = "Una comedia imprescindible con personajes inolvidables y un humor que mejora con cada temporada.",
                autor = "SeeShow"
            ),
            reparto = listOf(
                Actor(1, "Brian Cox", "Logan Roy", R.drawable.britt_lower),
                Actor(2, "Jeremy Strong", "Kendall Roy", R.drawable.britt_lower),
                Actor(3, "Sarah Snook", "Shiv Roy", R.drawable.britt_lower),
                Actor(4, "Kieran Culkin", "Roman Roy", R.drawable.britt_lower),
                Actor(5, "Matthew Macfadyen", "Tom Wambsgans", R.drawable.britt_lower)
            )
        )

        val narcos = Serie(
            id = 3,
            titulo = "Narcos",
            imagenPoster = R.drawable.succesion,
            imagenFondo = R.drawable.imagen_cabecera_severance,
            fechaInicio = "2015-08-28",
            creadaPor = "Chris Brancato, Carlo Bernard y Doug Miro",
            dirigidaPor = "Andrés Baiz",
            descripcion = "La historia del auge del narcotráfico en Colombia y la lucha de las autoridades por acabar con los grandes cárteles de la droga.",
            plataformas = listOf("Netflix"),
            puntuacion = 8.8,
            numeroTemporadas = 3,
            numeroCapitulos = 30,
            resenaPremium = Resena(
                texto = "Una producción intensa que combina acontecimientos históricos, acción y grandes interpretaciones.",
                autor = "SeeShow"
            ),
            reparto = listOf(
                Actor(1, "Brian Cox", "Logan Roy", R.drawable.britt_lower),
                Actor(2, "Jeremy Strong", "Kendall Roy", R.drawable.britt_lower),
                Actor(3, "Sarah Snook", "Shiv Roy", R.drawable.britt_lower),
                Actor(4, "Kieran Culkin", "Roman Roy", R.drawable.britt_lower),
                Actor(5, "Matthew Macfadyen", "Tom Wambsgans", R.drawable.britt_lower)
            )
        )

        // Establecemos las relaciones entre series
        val successionRelacionada = succession.copy(
            seriesRelacionadasIds = listOf("2", "3")
        )

        val theOfficeRelacionada = theOffice.copy(
            seriesRelacionadasIds = listOf("1", "3")
        )

        val narcosRelacionada = narcos.copy(
            seriesRelacionadasIds = listOf("1", "2")
        )

        return listOf(
            successionRelacionada,
            theOfficeRelacionada,
            narcosRelacionada
        )
    }
