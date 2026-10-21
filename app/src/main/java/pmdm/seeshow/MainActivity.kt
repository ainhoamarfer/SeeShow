package pmdm.seeshow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pmdm.seeshow.ui.pagina.PantallaPrincipal
import pmdm.seeshow.ui.theme.SeeShowTheme
import pmdm.seeshow.ui.viewmodel.PantallaPrincipalVM

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SeeShowTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {

                    }
                )
                { innerPadding ->
                    ComponentList(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ComponentList(modifier: Modifier = Modifier) {
    //meter aqui los componentes
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SeeShowTheme {
        Surface {
            ComponentList()
        }
    }
}