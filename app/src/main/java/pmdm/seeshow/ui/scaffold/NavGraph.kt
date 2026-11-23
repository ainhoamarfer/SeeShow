package pmdm.seeshow.ui.scaffold

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
@Serializable
data class RutaDetalle(val id: Int)
@Serializable
data object RutaLista


// las paginas no pueden tener de parametro NavHostController, es un crimen, si cambiases de este sistema a otro tendrias que cambiar todas las paginas
@Composable
fun AppNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = RutaLista
    ) {
        //enganchamos la ruta a la pagina
        composable<RutaLista> {
            PantallaListado(onCardClick = {
                navController.navigate(RutaDetalle(it))
            })
        }

        composable<RutaDetalle> { backStackEntry ->                 //usar esta forma, importante
            val id = backStackEntry.toRoute<RutaDetalle>().id
            PantallaDetalle(
                serieId = id,
                onGoBack = {
                    navController.popBackStack()
                }
            )
        }

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