package pmdm.seeshow.ui.scaffold

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import pmdm.seeshow.ui.pagina.PantallaDetalle
import pmdm.seeshow.ui.pagina.PantallaListado

@Serializable
data object RutaSeries

@Serializable
data object RutaCrear

@Serializable
data object RutaForos

@Serializable
data object RutaPerfil

@Serializable
data object RutaAjustes
@Serializable data class RutaDetalle (val id: Int)
@Serializable data object RutaLista

@Composable
fun AppNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = RutaLista          // pantalla inicial: un objeto, no un String
    ) {
        composable<RutaLista> {
            PantallaListado(onCardClick = {
                navController.navigate(RutaDetalle(it))
                })
        }

        composable<RutaDetalle> {
            val rutaDetalle = it.toRoute<RutaDetalle>()   // leer los parámetros
            PantallaDetalle(
                serieId = rutaDetalle.id
            )
        }

        //composable<Ajustes> {
        //    AjustesScreen(onVolver = { navController.popBackStack() })
        //}

        composable<RutaSeries> {
            Text("En construccion")
        }

        composable<RutaCrear> {
            Text("En construccion")
        }

        composable<RutaForos> {
            Text("En construccion")
        }

        composable<RutaPerfil> {
            Text("En construccion")
        }

        composable<RutaAjustes> {
            Text("En construccion")
        }
    }
}