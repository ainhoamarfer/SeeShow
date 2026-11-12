package pmdm.seeshow.seeder

import pmdm.seeshow.R
import pmdm.seeshow.ui.scaffold.MenuDrawerData
import pmdm.seeshow.ui.scaffold.OpcionDrawer

fun obtenerDatos(): MenuDrawerData {

    return MenuDrawerData(
        descubrir = OpcionDrawer(
            titulo = R.string.descubrir,
            icono = R.drawable.eye,
            id = 0
        ),

        series = OpcionDrawer(
            titulo = R.string.series,
            icono = R.drawable.series,
            id = 1
        ),

        crear = OpcionDrawer(
            titulo = R.string.crear,
            icono = R.drawable.crear,
            id = 2
        ),

        foros = OpcionDrawer(
            titulo = R.string.foros,
            icono = R.drawable.foros,
            id = 3
        ),

        perfil = OpcionDrawer(
            titulo = R.string.perfil,
            icono = R.drawable.usuario,
            id = 4
        )
    )
}