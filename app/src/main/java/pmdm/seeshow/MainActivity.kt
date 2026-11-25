package pmdm.seeshow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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

                AppScaffold(
                    onHomeClick = {navGraphController.navigate(RutaLista)},
                    onSeriesClick = {navGraphController.navigate(RutaSeries)},
                    onCrearClick = {navGraphController.navigate(RutaCrear)},
                    onForosClick = {navGraphController.navigate(RutaForos)},
                    onPerfilClick = {navGraphController.navigate(RutaPerfil)},
                    onAjustesClick = {navGraphController.navigate(RutaAjustes)}
                ) {

                    // Dentro del Scaffold mostramos el NavGraph
                    AppNavGraph(navGraphController)
                }
            }
        }
    }
}

