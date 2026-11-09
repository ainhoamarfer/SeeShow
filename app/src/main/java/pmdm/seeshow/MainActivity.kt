package pmdm.seeshow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import pmdm.seeshow.ui.scaffold.AppScaffold
import pmdm.seeshow.ui.theme.SeeShowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SeeShowTheme {
                AppScaffold();
            }
        }
    }
}

