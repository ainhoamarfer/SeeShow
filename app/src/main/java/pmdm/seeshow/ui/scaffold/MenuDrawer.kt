package pmdm.seeshow.ui.scaffold

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerState

import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import pmdm.seeshow.ui.theme.Primary
import pmdm.seeshow.ui.theme.SurfaceComponent
import pmdm.seeshow.ui.theme.TextWhite



// Datos de una opción del menú
data class OpcionDrawer(
    val titulo: Int,
    val icono: Int,
    val id: Int
)

// Datos de todas las opciones del menú
data class MenuDrawerData(
    val descubrir: OpcionDrawer,
    val series: OpcionDrawer,
    val crear: OpcionDrawer,
    val foros: OpcionDrawer,
    val perfil: OpcionDrawer
)

@Composable
fun MenuDrawer(
    drawerState: DrawerState,
    datos: MenuDrawerData,
    pantallaSeleccionada: Int,
    onPantallaSeleccionada: (Int) -> Unit,
    content: @Composable () -> Unit
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = SurfaceComponent
            ) {

                // DESCUBRIR
                NavigationDrawerItem(
                    label = {
                        Text(stringResource(datos.descubrir.titulo))
                    },
                    icon = {
                        Icon(
                            painter = painterResource(datos.descubrir.icono),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    selected = pantallaSeleccionada == datos.descubrir.id,
                    onClick = {
                        onPantallaSeleccionada(datos.descubrir.id)
                    },
                    shape = RoundedCornerShape(4.dp),

                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Primary,
                        selectedTextColor = SurfaceComponent,
                        selectedIconColor = SurfaceComponent,
                        unselectedTextColor = TextWhite,
                        unselectedIconColor = TextWhite
                    )
                )

                // SERIES
                NavigationDrawerItem(
                    label = {
                        Text(stringResource(datos.series.titulo))
                    },
                    icon = {
                        Icon(
                            painter = painterResource(datos.series.icono),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    selected = pantallaSeleccionada == datos.series.id,
                    onClick = {
                        onPantallaSeleccionada(datos.series.id)
                    },
                    shape = RoundedCornerShape(4.dp),

                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Primary,
                        selectedTextColor = SurfaceComponent,
                        selectedIconColor = SurfaceComponent,
                        unselectedTextColor = TextWhite,
                        unselectedIconColor = TextWhite
                    )
                )

                // CREAR
                NavigationDrawerItem(
                    label = {
                        Text(stringResource(datos.crear.titulo))
                    },
                    icon = {
                        Icon(
                            painter = painterResource(datos.crear.icono),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    selected = pantallaSeleccionada == datos.crear.id,
                    onClick = {
                        onPantallaSeleccionada(datos.crear.id)
                    },
                    shape = RoundedCornerShape(4.dp),

                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Primary,
                        selectedTextColor = SurfaceComponent,
                        selectedIconColor = SurfaceComponent,
                        unselectedTextColor = TextWhite,
                        unselectedIconColor = TextWhite
                    )
                )

                // FOROS
                NavigationDrawerItem(
                    label = {
                        Text(stringResource(datos.foros.titulo))
                    },
                    icon = {
                        Icon(
                            painter = painterResource(datos.foros.icono),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    selected = pantallaSeleccionada == datos.foros.id,
                    onClick = {
                        onPantallaSeleccionada(datos.foros.id)
                    },
                    shape = RoundedCornerShape(4.dp),

                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Primary,
                        selectedTextColor = SurfaceComponent,
                        selectedIconColor = SurfaceComponent,
                        unselectedTextColor = TextWhite,
                        unselectedIconColor = TextWhite
                    )
                )

                // PERFIL
                NavigationDrawerItem(
                    label = {
                        Text(stringResource(datos.perfil.titulo))
                    },
                    icon = {
                        Icon(
                            painter = painterResource(datos.perfil.icono),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    selected = pantallaSeleccionada == datos.perfil.id,
                    onClick = {
                        onPantallaSeleccionada(datos.perfil.id)
                    },
                    shape = RoundedCornerShape(4.dp),

                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Primary,
                        selectedTextColor = SurfaceComponent,
                        selectedIconColor = SurfaceComponent,
                        unselectedTextColor = TextWhite,
                        unselectedIconColor = TextWhite
                    )
                )

            }
        }
    ) {
        content()
    }
}