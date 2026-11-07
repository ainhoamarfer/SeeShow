package pmdm.seeshow.ui.scaffold

import android.R.attr.navigationIcon
import android.R.attr.title
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pmdm.seeshow.R
import pmdm.seeshow.ui.theme.AppTypography
import pmdm.seeshow.ui.theme.BackgroundBlack
import pmdm.seeshow.ui.theme.Primary
import pmdm.seeshow.ui.theme.SeeShowTheme
import pmdm.seeshow.ui.theme.SurfaceComponent
import pmdm.seeshow.ui.theme.TextWhite


@Composable
fun AppScaffold() {

    // Opción seleccionada en la barra inferior
    var pantallaSeleccionada by remember {
        mutableIntStateOf(0)
    }

    Scaffold(

        //topBar = {
        //    navigationIcon = {
        //        IconButton(onClick = { /* abrir menú o volver atrás */ }) {
        //            Icon(painterResource(id = R.drawable.eye), contentDescription = "Abrir menú")
        //        }
        //    }
//
        //},

        // Barra inferior
        bottomBar = {
            NavigationBar {

                //Boton descubrir
                NavigationBarItem(
                    selected = pantallaSeleccionada == 0,
                    onClick = { pantallaSeleccionada = 0 },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.eye),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(R.string.descubrir),
                            style = AppTypography.labelSmall
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Primary,
                        unselectedIconColor = TextWhite,
                        selectedTextColor = Primary,
                        unselectedTextColor = TextWhite,
                        indicatorColor = SurfaceComponent
                    )
                )

                //Boton series
                NavigationBarItem(
                    selected = pantallaSeleccionada == 1,
                    onClick = { pantallaSeleccionada = 1 },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.series),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(R.string.series),
                            style = AppTypography.labelSmall
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Primary,
                        unselectedIconColor = TextWhite,
                        selectedTextColor = Primary,
                        unselectedTextColor = TextWhite,
                        indicatorColor = SurfaceComponent
                    )
                )

                //Botn central crear
                NavigationBarItem(
                    selected = pantallaSeleccionada == 2,
                    onClick = {
                        // Acción de crear
                    },
                    icon = {
                        Box(
                            modifier = Modifier
                                .size(54.dp)
                                .clip(CircleShape)
                                .background(Primary),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.crear),
                                contentDescription = "Crear",
                                tint = SurfaceComponent,
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    },
                    label = null
                )

                NavigationBarItem(
                    selected = pantallaSeleccionada == 3,
                    onClick = { pantallaSeleccionada = 3 },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.foro),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(R.string.foros),
                            style = AppTypography.labelSmall
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Primary,
                        unselectedIconColor = TextWhite,
                        selectedTextColor = Primary,
                        unselectedTextColor = TextWhite,
                        indicatorColor = SurfaceComponent
                    )
                )

                NavigationBarItem(
                    selected = pantallaSeleccionada == 4,
                    onClick = { pantallaSeleccionada = 4 },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.usuario),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(R.string.perfil),
                            style = AppTypography.labelSmall
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Primary,
                        unselectedIconColor = TextWhite,
                        selectedTextColor = Primary,
                        unselectedTextColor = TextWhite,
                        indicatorColor = SurfaceComponent
                    )
                )

            }
        }

    ) { innerPadding ->

        // Contenido central
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {

            when (pantallaSeleccionada) {
                0 -> Text("Descubrir")
                1 -> Text("Series")
                2 -> Text("Crear")
                3 -> Text("Foros")
                4 -> Text("Perfil")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScaffoldPreview() {
    SeeShowTheme {
        Surface {
            AppScaffold()
        }
    }
}