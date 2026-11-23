package pmdm.seeshow.ui.pagina

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import pmdm.seeshow.R
import pmdm.seeshow.ui.componente.BotonData
import pmdm.seeshow.ui.componente.Botones
import pmdm.seeshow.ui.componente.VarianteBoton
import pmdm.seeshow.ui.theme.SeeShowTheme
import pmdm.seeshow.ui.viewmodel.PantallaLogInVM

@Composable
fun PantallaLogIn (
    vm: PantallaLogInVM = viewModel()
) {

    val state by vm.uiState.collectAsState()

    Column() {
        OutlinedTextField(
            value = state.email,
            onValueChange = {
                vm.onEmailChange(it) },
            label = { Text("Email") },
            isError = state.errorEmail != null,
            supportingText = {
                Text(state.errorEmail ?: "")
            }

        )

        OutlinedTextField(
            value = state.contrasena,
            onValueChange = {vm.onContraChange(it)},
            label = { Text("Contraseña") },
            isError = state.errorContra != null,
            supportingText = {
                Text(state.errorContra ?: "")
            }

        )

        Botones(
            //enabled = vm.isError(),
            enum = VarianteBoton.BASICO_ACTIVO,
            data = BotonData(
                id = 1,
                texto = stringResource(R.string.guardar),
                onClic = {

                }
            )
        )

        ExposedDropdownMenuBox(
            expanded = state.expanded,
            onExpandedChange = {vm.onExpandedChange(it)}
        ) {
            OutlinedTextField(
                value = state.email
                onValueChange = {},
                label = { Text("Email") },
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(state.expanded) },
                modifier = Modifier
                    .menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable)
            )

        }


    }
}

@Preview
@Composable
fun PantallaLogInPreview() {
    SeeShowTheme {
        Surface {
            PantallaLogIn()
        }
    }
}