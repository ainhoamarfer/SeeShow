package pmdm.seeshow.seeder

import pmdm.seeshow.R
import pmdm.seeshow.dominio.modelo.Actor
import pmdm.seeshow.ui.componente.DatosSerieListadoCard
import pmdm.seeshow.ui.componente.TipoSerieCard

fun listaActores(): List<Actor> {
    return listOf(
        // Succession
        Actor(
            id = 1,
            nombre = "Jeremy Strong",
            personaje = "Kendall Roy",
            imagen = R.drawable.britt_lower
        ),
        Actor(
            id = 2,
            nombre = "Sarah Snook",
            personaje = "Shiv Roy",
            imagen = R.drawable.britt_lower
        ),
        Actor(
            id = 3,
            nombre = "Kieran Culkin",
            personaje = "Roman Roy",
            imagen = R.drawable.britt_lower
        ),

        // The Office
        Actor(
            id = 4,
            nombre = "Steve Carell",
            personaje = "Michael Scott",
            imagen = R.drawable.britt_lower
        ),
        Actor(
            id = 5,
            nombre = "John Krasinski",
            personaje = "Jim Halpert",
            imagen = R.drawable.britt_lower
        ),
        Actor(
            id = 6,
            nombre = "Jenna Fischer",
            personaje = "Pam Beesly",
            imagen = R.drawable.britt_lower
        ),

        // Breaking Bad
        Actor(
            id = 7,
            nombre = "Bryan Cranston",
            personaje = "Walter White",
            imagen = R.drawable.britt_lower
        ),
        Actor(
            id = 8,
            nombre = "Aaron Paul",
            personaje = "Jesse Pinkman",
            imagen = R.drawable.britt_lower
        ),
        Actor(
            id = 9,
            nombre = "Anna Gunn",
            personaje = "Skyler White",
            imagen = R.drawable.britt_lower
        )
    )
}

fun getActoresFiltrados(filter: String): List<Actor> {
    return listaActores().filter {
        it.nombre.contains(filter, ignoreCase = true) ||
                it.personaje.contains(filter, ignoreCase = true)
    }
}

fun getActor(id: Int): Actor? {
    return listaActores().find {
        it.id == id
    }
}

fun getActoresCard(): List<DatosSerieListadoCard> {
    return listaActores().map { actor ->
        DatosSerieListadoCard(
            id = actor.id,
            recursoImagen = actor.imagen,
            titulo = actor.personaje,
            subtitulo = actor.nombre,
            tipo = TipoSerieCard.VERTICAL
        )
    }
}