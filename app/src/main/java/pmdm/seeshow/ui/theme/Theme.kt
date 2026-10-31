package pmdm.seeshow.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    // Primario
    primary = Primary,
    onPrimary = BackgroundBlack,
    primaryContainer = PrimaryDark,
    onPrimaryContainer = TextWhite,

    // Secundario
    secondary = Secondary,
    onSecondary = BackgroundBlack,
    secondaryContainer = SecondaryDark,
    onSecondaryContainer = TextWhite,

    // Fondo de pantalla
    background = BackgroundBlack,
    onBackground = TextWhite,

    // Superficie base (igual al fondo)
    surface = BackgroundBlack,
    onSurface = TextWhite,

    // Superficie de componentes (cards, chips, dialogs...)
    surfaceVariant = SurfaceComponent,
    onSurfaceVariant = TextWhite,
    surfaceContainerLowest = SurfaceComponent,
    surfaceContainerLow = SurfaceComponent,
    surfaceContainer = SurfaceComponent,
    surfaceContainerHigh = SurfaceComponent,
    surfaceContainerHighest = SurfaceComponent,

    // Acento spoiler
    error = SpoilerAccent,
    onError = TextWhite
)

@Composable
fun SeeShowTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            window.navigationBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).apply {
                isAppearanceLightStatusBars = false
                isAppearanceLightNavigationBars = false
            }
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}