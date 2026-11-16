package pmdm.seeshow.seeder

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pmdm.seeshow.R
import pmdm.seeshow.dominio.modelo.Serie
import pmdm.seeshow.ui.componente.TipoSerieCard
import kotlin.Double


    fun listaSeries(): List<Serie> {

        val succession = Serie(
            id = 1,
            titulo = "Succession",
            imagenPoster = "https://image.tmdb.org/t/p/w500/7HW47XbkNQ5fiwQFYGWdw9gs144.jpg",
            imagenFondo = "https://image.tmdb.org/t/p/original/8p9E9F0w9yQ2xQ5xQ8xQ8xQ8xQ8.jpg",
            fechaInicio = "2018-06-03",
            creadaPor = "Jesse Armstrong",
            dirigidaPor = "Mark Mylod",
            descripcion = "La familia Roy, propietaria de uno de los mayores conglomerados de medios de comunicación y entretenimiento del mundo, lucha por mantener el control de su imperio empresarial.",
            plataforma = "Max",
            puntuacion = 8.9,
            porcentajeCompletada = 75,
            numeroTemporadas = 4,
            numeroCapitulos = 39,
            resenaPremium = Resena(
                texto = "Una de las mejores sátiras sobre el poder, el dinero y las relaciones familiares. Su guion y sus interpretaciones son extraordinarios.",
                autor = "SeeShow"
            ),
            reparto = listOf(
                Actor(1, "Brian Cox", "Logan Roy", ""),
                Actor(2, "Jeremy Strong", "Kendall Roy", ""),
                Actor(3, "Sarah Snook", "Shiv Roy", ""),
                Actor(4, "Kieran Culkin", "Roman Roy", ""),
                Actor(5, "Matthew Macfadyen", "Tom Wambsgans", "")
            )
        )

        val theOffice = Serie(
            id = 2,
            titulo = "The Office",
            imagenPoster = "https://image.tmdb.org/t/p/w500/qWnJzyZhyy74gjpSjIXWmuk0ifX.jpg",
            imagenFondo = "",
            fechaInicio = "2005-03-24",
            creadaPor = "Greg Daniels",
            dirigidaPor = "Ken Kwapis",
            descripcion = "Una divertida comedia que sigue el día a día de los empleados de una empresa papelera en Scranton, Pensilvania, donde las situaciones absurdas nunca faltan.",
            plataforma = "Netflix",
            puntuacion = 9.0,
            porcentajeCompletada = 100,
            numeroTemporadas = 9,
            numeroCapitulos = 201,
            resenaPremium = Resena(
                texto = "Una comedia imprescindible con personajes inolvidables y un humor que mejora con cada temporada.",
                autor = "SeeShow"
            ),
            reparto = listOf(
                Actor(6, "Steve Carell", "Michael Scott", ""),
                Actor(7, "John Krasinski", "Jim Halpert", ""),
                Actor(8, "Jenna Fischer", "Pam Beesly", ""),
                Actor(9, "Rainn Wilson", "Dwight Schrute", ""),
                Actor(10, "Mindy Kaling", "Kelly Kapoor", "")
            )
        )

        val narcos = Serie(
            id = 3,
            titulo = "Narcos",
            imagenPoster = "https://image.tmdb.org/t/p/w500/rTmal9fDbwh5F0waol2hq35U4ah.jpg",
            imagenFondo = "",
            fechaInicio = "2015-08-28",
            creadaPor = "Chris Brancato, Carlo Bernard y Doug Miro",
            dirigidaPor = "Andrés Baiz",
            descripcion = "La historia del auge del narcotráfico en Colombia y la lucha de las autoridades por acabar con los grandes cárteles de la droga.",
            plataforma = "Netflix",
            puntuacion = 8.8,
            porcentajeCompletada = 45,
            numeroTemporadas = 3,
            numeroCapitulos = 30,
            resenaPremium = Resena(
                texto = "Una producción intensa que combina acontecimientos históricos, acción y grandes interpretaciones.",
                autor = "SeeShow"
            ),
            reparto = listOf(
                Actor(11, "Wagner Moura", "Pablo Escobar", ""),
                Actor(12, "Boyd Holbrook", "Steve Murphy", ""),
                Actor(13, "Pedro Pascal", "Javier Peña", ""),
                Actor(14, "Paulina Gaitán", "Tata Escobar", "")
            )
        )

        // Establecemos las relaciones entre series
        val successionRelacionada = succession.copy(
            seriesRelacionadas = listOf(theOffice, narcos)
        )

        val theOfficeRelacionada = theOffice.copy(
            seriesRelacionadas = listOf(succession, narcos)
        )

        val narcosRelacionada = narcos.copy(
            seriesRelacionadas = listOf(succession, theOffice)
        )

        return listOf(
            successionRelacionada,
            theOfficeRelacionada,
            narcosRelacionada
        )
    }
}