package pmdm.seeshow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import pmdm.seeshow.ui.theme.SeeShowTheme
import androidx.navigation.compose.rememberNavController
import pmdm.seeshow.ui.scaffold.AppNavGraph
import pmdm.seeshow.ui.scaffold.AppScaffold
import pmdm.seeshow.ui.scaffold.RutaAjustes
import pmdm.seeshow.ui.scaffold.RutaCrear
import pmdm.seeshow.ui.scaffold.RutaForos
import pmdm.seeshow.ui.scaffold.RutaLista
import pmdm.seeshow.ui.scaffold.RutaPerfil
import pmdm.seeshow.ui.scaffold.RutaSeries

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navGraphController = rememberNavController()

            SeeShowTheme {


                // Obtenemos el destino actual
                val navBackStackEntry by navGraphController.currentBackStackEntryAsState()
                val destinoActual = navBackStackEntry?.destination

                // Identificamos la opción seleccionada
                val pantallaSeleccionada = when (destinoActual?.route) {
                    RutaLista::class.qualifiedName -> 0
                    RutaSeries::class.qualifiedName -> 1
                    RutaCrear::class.qualifiedName -> 2
                    RutaForos::class.qualifiedName -> 3
                    RutaPerfil::class.qualifiedName -> 4
                    RutaAjustes::class.qualifiedName -> 5
                    else -> -1
                }

                // Mostramos el Scaffold
                AppScaffold(
                    pantallaSeleccionada = pantallaSeleccionada,

                    onNavegar = { pantalla ->
                        when (pantalla) {
                            0 -> navGraphController.navigate(RutaLista)
                            1 -> navGraphController.navigate(RutaSeries)
                            2 -> navGraphController.navigate(RutaCrear)
                            3 -> navGraphController.navigate(RutaForos)
                            4 -> navGraphController.navigate(RutaPerfil)
                            5 -> navGraphController.navigate(RutaAjustes)
                        }
                    }
                ) {

                    // Dentro del Scaffold mostramos el NavGraph
                    AppNavGraph(navGraphController)
                }
            }
        }
    }
}

