package pmdm.seeshow.seeder

import pmdm.seeshow.R
import pmdm.seeshow.ui.scaffold.MenuDrawerData
import pmdm.seeshow.ui.scaffold.OpcionDrawer
import pmdm.seeshow.ui.scaffold.UltimaPantallaSeleccionada

fun obtenerDatos(): MenuDrawerData {
    return MenuDrawerData(
        descubrir = OpcionDrawer(
            titulo = R.string.descubrir,
            icono = R.drawable.eye,
            pantalla = UltimaPantallaSeleccionada.DESCUBRIR
        ),

        series = OpcionDrawer(
            titulo = R.string.series,
            icono = R.drawable.series,
            pantalla = UltimaPantallaSeleccionada.SERIES
        ),

        crear = OpcionDrawer(
            titulo = R.string.crear,
            icono = R.drawable.crear,
            pantalla = UltimaPantallaSeleccionada.CREAR
        ),

        foros = OpcionDrawer(
            titulo = R.string.foros,
            icono = R.drawable.foros,
            pantalla = UltimaPantallaSeleccionada.FOROS
        ),

        perfil = OpcionDrawer(
            titulo = R.string.perfil,
            icono = R.drawable.usuario,
            pantalla = UltimaPantallaSeleccionada.PERFILES
        )
    )
}