package pmdm.seeshow

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import pmdm.seeshow.ui.pagina.PantallaListado
import pmdm.seeshow.ui.theme.SeeShowTheme

class MainActivity : ComponentActivity() {

    private val TAG = "CICLO_VIDA"
    private var contador = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        contador = savedInstanceState?.getInt("CONTADOR") ?: 0

        Log.d(TAG, "onCreate: Activity creada. Contador: \$contador")

        enableEdgeToEdge()

        setContent {
            SeeShowTheme {

                var contadorUI by remember {
                    mutableIntStateOf(contador)
                }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                    //TODO hacer Scaffold
                    }
                )
                { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding)
                    ) {

                        Button(
                            onClick = {
                                contadorUI++
                                contador = contadorUI
                            }
                        ) {
                            Text("Contador: $contadorUI")
                        }

                        PantallaListado(
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("CONTADOR", contador)

        Log.d(TAG, "onSaveInstanceState: Contador guardado")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Activity visible")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: Activity en primer plano")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Activity pierde el primer plano")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Activity deja de ser visible")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Activity destruida")
    }
}


