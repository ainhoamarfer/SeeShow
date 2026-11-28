package pmdm.seeshow.seeder

import pmdm.seeshow.R
import pmdm.seeshow.dominio.modelo.Serie


fun datosSerie(): List<Serie> {
    return listOf(
        Serie(
            id = 0,
            titulo = "Succession",
            imagenPoster = R.drawable.succesion,
            imagenFondo = R.drawable.succesion,
            fechaInicio = "2018-06-03",
            creadaPor = "Jesse Armstrong",
            dirigidaPor = "Mark Mylod",
            descripcion = "La familia Roy controla uno de los mayores conglomerados de medios y entretenimiento del mundo. Sus miembros luchan por mantener el poder y conseguir el control de la empresa.",
            plataformas = listOf("Max"),
            puntuacion = 4.8,
            numeroTemporadas = 4,
            numeroCapitulos = 39,
            seriesRelacionadasIds = listOf("2", "3")
        ),

        Serie(
            id = 1,
            titulo = "The Office",
            imagenPoster = R.drawable.succesion,
            imagenFondo = R.drawable.succesion,
            fechaInicio = "2005-03-24",
            creadaPor = "Greg Daniels",
            dirigidaPor = "Ken Kwapis",
            descripcion = "Una mirada cómica a la vida cotidiana de los empleados de una oficina de ventas de papel en Scranton, Pensilvania.",
            plataformas = listOf("Netflix", "Max"),
            puntuacion = 4.8,
            numeroTemporadas = 9,
            numeroCapitulos = 201,
            seriesRelacionadasIds = listOf("3", "4")
        ),

        Serie(
            id = 2,
            titulo = "Narcos",
            imagenPoster = R.drawable.succesion,
            imagenFondo = R.drawable.succesion,
            fechaInicio = "2015-08-28",
            creadaPor = "Chris Brancato, Carlo Bernard y Doug Miro",
            dirigidaPor = "José Padilha",
            descripcion = "La historia del narcotráfico en Colombia y la lucha de las autoridades contra los grandes cárteles de la droga.",
            plataformas = listOf("Netflix"),
            puntuacion = 4.7,
            numeroTemporadas = 3,
            numeroCapitulos = 30,
            seriesRelacionadasIds = listOf("4", "5")
        ),

        Serie(
            id = 3,
            titulo = "Friends",
            imagenPoster = R.drawable.succesion,
            imagenFondo = R.drawable.succesion,
            fechaInicio = "1994-09-22",
            creadaPor = "David Crane y Marta Kauffman",
            dirigidaPor = "James Burrows",
            descripcion = "Seis amigos comparten sus vidas, relaciones y aventuras mientras viven en Nueva York.",
            plataformas = listOf("Max", "Netflix"),
            puntuacion = 4.9,
            numeroTemporadas = 10,
            numeroCapitulos = 236,
            seriesRelacionadasIds = listOf("6", "7")
        ),

        Serie(
            id = 4,
            titulo = "Breaking Bad",
            imagenPoster = R.drawable.succesion,
            imagenFondo = R.drawable.succesion,
            fechaInicio = "2008-01-20",
            creadaPor = "Vince Gilligan",
            dirigidaPor = "Vince Gilligan",
            descripcion = "Un profesor de química diagnosticado con cáncer comienza a fabricar metanfetamina junto a un antiguo alumno para asegurar el futuro económico de su familia.",
            plataformas = listOf("Netflix"),
            puntuacion = 4.9,
            numeroTemporadas = 5,
            numeroCapitulos = 62,
            seriesRelacionadasIds = listOf("3", "8")
        ),

        Serie(
            id = 5,
            titulo = "Stranger Things",
            imagenPoster = R.drawable.succesion,
            imagenFondo = R.drawable.succesion,
            fechaInicio = "2016-07-15",
            creadaPor = "Matt Duffer y Ross Duffer",
            dirigidaPor = "Matt Duffer y Ross Duffer",
            descripcion = "Un grupo de amigos descubre misteriosos experimentos gubernamentales y fuerzas sobrenaturales en su pequeño pueblo.",
            plataformas = listOf("Netflix"),
            puntuacion = 4.8,
            numeroTemporadas = 5,
            numeroCapitulos = 42,
            seriesRelacionadasIds = listOf("7", "9")
        ),

        Serie(
            id = 6,
            titulo = "Black Mirror",
            imagenPoster = R.drawable.succesion,
            imagenFondo = R.drawable.succesion,
            fechaInicio = "2011-12-04",
            creadaPor = "Charlie Brooker",
            dirigidaPor = "Varios directores",
            descripcion = "Una antología que explora cómo la tecnología puede influir en la sociedad y transformar nuestras vidas.",
            plataformas = listOf("Netflix"),
            puntuacion = 4.7,
            numeroTemporadas = 7,
            numeroCapitulos = 33,
            seriesRelacionadasIds = listOf("6", "10")
        ),

        Serie(
            id = 7,
            titulo = "The Last of Us",
            imagenPoster = R.drawable.succesion,
            imagenFondo = R.drawable.succesion,
            fechaInicio = "2023-01-15",
            creadaPor = "Craig Mazin y Neil Druckmann",
            dirigidaPor = "Craig Mazin",
            descripcion = "En un mundo devastado por una infección, Joel debe proteger a Ellie durante un peligroso viaje por Estados Unidos.",
            plataformas = listOf("Max"),
            puntuacion = 4.8,
            numeroTemporadas = 2,
            numeroCapitulos = 16,
            seriesRelacionadasIds = listOf("5", "6")
        ),

        Serie(
            id = 8,
            titulo = "Dark",
            imagenPoster = R.drawable.succesion,
            imagenFondo = R.drawable.succesion,
            fechaInicio = "2017-12-01",
            creadaPor = "Baran bo Odar y Jantje Friese",
            dirigidaPor = "Baran bo Odar",
            descripcion = "La desaparición de un niño destapa los secretos de cuatro familias y una misteriosa conexión entre distintas épocas.",
            plataformas = listOf("Netflix"),
            puntuacion = 4.8,
            numeroTemporadas = 3,
            numeroCapitulos = 26,
            seriesRelacionadasIds = listOf("6", "7")
        ),

        Serie(
            id = 9,
            titulo = "The Boys",
            imagenPoster = R.drawable.succesion,
            imagenFondo = R.drawable.succesion,
            fechaInicio = "2019-07-26",
            creadaPor = "Eric Kripke",
            dirigidaPor = "Varios directores",
            descripcion = "Un grupo de vigilantes intenta detener a superhéroes corruptos que utilizan sus poderes para beneficio propio.",
            plataformas = listOf("Prime Video"),
            puntuacion = 4.7,
            numeroTemporadas = 5,
            numeroCapitulos = 40,
            seriesRelacionadasIds = listOf("7", "11")
        ),

        Serie(
            id = 10,
            titulo = "Sherlock",
            imagenPoster = R.drawable.succesion,
            imagenFondo = R.drawable.succesion,
            fechaInicio = "2010-07-25",
            creadaPor = "Mark Gatiss y Steven Moffat",
            dirigidaPor = "Paul McGuigan",
            descripcion = "Una adaptación moderna de las aventuras del detective Sherlock Holmes y su compañero John Watson en Londres.",
            plataformas = listOf("Netflix"),
            puntuacion = 4.9,
            numeroTemporadas = 4,
            numeroCapitulos = 13,
            seriesRelacionadasIds = listOf("4", "12")
        ),

        Serie(
            id = 11,
            titulo = "Peaky Blinders",
            imagenPoster = R.drawable.succesion,
            imagenFondo = R.drawable.succesion,
            fechaInicio = "2013-09-12",
            creadaPor = "Steven Knight",
            dirigidaPor = "Otto Bathurst",
            descripcion = "La familia Shelby dirige una peligrosa banda criminal en Birmingham durante los años posteriores a la Primera Guerra Mundial.",
            plataformas = listOf("Netflix"),
            puntuacion = 4.8,
            numeroTemporadas = 6,
            numeroCapitulos = 36,
            seriesRelacionadasIds = listOf("3", "10")
        ),

        Serie(
            id = 12,
            titulo = "Game of Thrones",
            imagenPoster = R.drawable.succesion,
            imagenFondo = R.drawable.succesion,
            fechaInicio = "2011-04-17",
            creadaPor = "David Benioff y D. B. Weiss",
            dirigidaPor = "Varios directores",
            descripcion = "Varias familias nobles luchan por el control del Trono de Hierro en un mundo fantástico lleno de intrigas, guerras y criaturas legendarias.",
            plataformas = listOf("Max"),
            puntuacion = 4.9,
            numeroTemporadas = 8,
            numeroCapitulos = 73,
            seriesRelacionadasIds = listOf("1", "12")
        )
    )
}
fun getSeriesFiltradas(filter: String): List<Serie>{
    return datosSerie().filter { it.titulo.contains(filter) }
}

fun getSerie(id: Int): Serie? {
    return datosSerie().find { it.id == id}
}