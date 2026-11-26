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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.foundation.Image
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import pmdm.seeshow.seeder.obtenerDatos
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    onHomeClick: () -> Unit,
    onSeriesClick: () -> Unit,
    onCrearClick: () -> Unit,
    onForosClick: () -> Unit,
    onPerfilClick: () -> Unit,
    onAjustesClick: () -> Unit,
    content: @Composable () -> Unit
) {

    // Estado del menú lateral
    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    //guarda estado snackbarHost
    val snackbarHostState = remember { SnackbarHostState() } //TODO para el futuro

    // Control de corrutinas para drawer y snackbarHost
    val scope = rememberCoroutineScope()

    // Datos del menú lateral
    val datosMenuDrawer = obtenerDatos()

    //para actualizar la pagina
    var ultimaPantallaSeleccionada by remember {
        mutableStateOf(UltimaPantallaSeleccionada.DESCUBRIR)
    }

    //el Drawer envuelve al Scaffold
    MenuDrawer(
        drawerState = drawerState,
        datos = datosMenuDrawer,
        pantallaSeleccionada = ultimaPantallaSeleccionada,
        onPantallaSeleccionada = { ultimaPantallaSeleccionada ->

            when (ultimaPantallaSeleccionada) {
                UltimaPantallaSeleccionada.DESCUBRIR -> onHomeClick()
                UltimaPantallaSeleccionada.SERIES -> onSeriesClick()
                UltimaPantallaSeleccionada.CREAR -> onCrearClick()
                UltimaPantallaSeleccionada.FOROS -> onForosClick()
                UltimaPantallaSeleccionada.PERFILES -> onPerfilClick()
            }

            // Cerramos el menú lateral
            scope.launch {
                drawerState.close()
            }
        }
    ) {

        Scaffold(

            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            },

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
                                onAjustesClick()
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
                        selected = ultimaPantallaSeleccionada == UltimaPantallaSeleccionada.DESCUBRIR,
                        onClick = {
                            onHomeClick()
                            ultimaPantallaSeleccionada = UltimaPantallaSeleccionada.DESCUBRIR
                        },
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
                        selected = ultimaPantallaSeleccionada == UltimaPantallaSeleccionada.SERIES,
                        onClick = {
                            onSeriesClick()
                            ultimaPantallaSeleccionada = UltimaPantallaSeleccionada.SERIES
                        },
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
                        selected = ultimaPantallaSeleccionada == UltimaPantallaSeleccionada.CREAR,
                        onClick = {
                            onCrearClick()
                            scope.launch {
                                snackbarHostState.showSnackbar("Nueva serie añadida")
                            }
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
                        selected = ultimaPantallaSeleccionada == UltimaPantallaSeleccionada.FOROS,
                        onClick = {
                            onForosClick()
                            ultimaPantallaSeleccionada = UltimaPantallaSeleccionada.FOROS
                        },
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
                        selected = ultimaPantallaSeleccionada == UltimaPantallaSeleccionada.PERFILES,
                        onClick = {
                            onPerfilClick()
                            ultimaPantallaSeleccionada = UltimaPantallaSeleccionada.PERFILES
                        },
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
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                content()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScaffoldPreview() {
    SeeShowTheme {
        Surface {
            AppScaffold(
                onHomeClick = {},
                onSeriesClick = {},
                onCrearClick = {},
                onForosClick = {},
                onPerfilClick = {},
                onAjustesClick = {}
            ) {
                Text(
                    text = "Contenido de la pantalla",
                    color = TextWhite
                )
            }
        }
    }
}