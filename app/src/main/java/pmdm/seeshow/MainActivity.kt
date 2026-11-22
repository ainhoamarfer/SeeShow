package pmdm.seeshow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import pmdm.seeshow.ui.pagina.PantallaListado
import pmdm.seeshow.ui.scaffold.AppScaffold
import pmdm.seeshow.ui.theme.SeeShowTheme
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SeeShowTheme {
                // Guardamos qué pantalla está seleccionada
                var pantallaSeleccionada by rememberSaveable {
                    mutableIntStateOf(0)
                }

                // Estructura general de la aplicación
                AppScaffold(

                    pantallaSeleccionada = pantallaSeleccionada,

                    onPantallaSeleccionada = { pantalla ->
                        pantallaSeleccionada = pantalla
                    }

                ) {

                    // Decidimos qué pantalla mostrar
                    when (pantallaSeleccionada) {

                        0 -> PantallaListado(
                            serieId = 1,
                            modifier = Modifier
                        )

                        1 -> Text("Pantalla Series")

                        2 -> Text("Pantalla Crear")

                        3 -> Text("Pantalla Foros")

                        4 -> Text("Pantalla Perfil")

                        5 -> Text("Pantalla Ajustes")
                    }
                }
            }
        }
    }
}

