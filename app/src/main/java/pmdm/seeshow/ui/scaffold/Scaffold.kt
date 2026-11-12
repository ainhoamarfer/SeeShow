package pmdm.seeshow.ui.scaffold

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
import kotlinx.coroutines.launch
import pmdm.seeshow.R
import pmdm.seeshow.ui.theme.*

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.foundation.Image
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import pmdm.seeshow.ui.pagina.PantallaListado
import pmdm.seeshow.seeder.obtenerDatos


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold() {

    // Estado del menú lateral
    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    // Opción seleccionada en la barra inferior
    var pantallaSeleccionada by remember {
        mutableIntStateOf(0)
    }
    // Control de corrutinas
    val scope = rememberCoroutineScope()

    // Datos del menú lateral
    val datosMenuDrawer = obtenerDatos()

    //el Drawer envuelve al Scaffold
    MenuDrawer(
        drawerState = drawerState,
        datos = datosMenuDrawer,
        pantallaSeleccionada = pantallaSeleccionada,
        onPantallaSeleccionada = { pantalla ->

            pantallaSeleccionada = pantalla

            // Cerramos el menú al seleccionar una opción
            scope.launch { drawerState.close() }
        }
    ) {

        Scaffold(

            topBar = {
                CenterAlignedTopAppBar(

                    //menu hamburguesa
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.menu),
                                contentDescription = "Abrir menú lateral",
                                tint = TextWhite,
                                modifier = Modifier.height(30.dp)
                            )
                        }
                    },

                    //Logo centrado
                    title = {
                        Image(
                            painter = painterResource(R.drawable.logo_seeshow),
                            contentDescription = "SeeShow",
                            modifier = Modifier.height(32.dp)
                        )
                    },

                    // Ajustes
                    actions = {
                        IconButton(
                            onClick = {
                                pantallaSeleccionada = 5
                            }
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ajustes),
                                contentDescription = "Ajustes",
                                tint = TextWhite,
                                modifier = Modifier.height(30.dp)
                            )
                        }
                    },

                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent,
                        scrolledContainerColor = BackgroundBlack,
                        navigationIconContentColor = TextWhite,
                        titleContentColor = TextWhite,
                        actionIconContentColor = TextWhite
                    )
                )
            },

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
                            // TODO Acción de crear
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
                                painter = painterResource(R.drawable.foros),
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
                    0 -> PantallaListado(
                        serieId = TODO(),
                        modifier = TODO(),
                        viewModel = TODO()
                    )
                    1 -> Text("Series")
                    2 -> Text("Crear")
                    3 -> Text("Foros")
                    4 -> Text("Perfil")
                }
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