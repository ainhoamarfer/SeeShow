package pmdm.seeshow.ui.pagina

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExposedDropdownMenuBox
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

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExposedDropdownMenu
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import pmdm.seeshow.ui.theme.BackgroundBlack
import pmdm.seeshow.ui.theme.Secondary
import pmdm.seeshow.ui.theme.SpoilerAccent
import pmdm.seeshow.ui.theme.TextWhite

@Composable
fun PantallaLogIn(
    vm: PantallaLogInVM = viewModel(),
    onLoginCorrecto: () -> Unit
) {

    val state by vm.uiState.collectAsState()

    //para snackbar de error
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        //Imagen de fondo
        Image(
            painter = painterResource(R.drawable.fondo_login),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        //el degradado de la imagen
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.65f),
                            Color.Black.copy(alpha = 0.75f),
                            BackgroundBlack
                        )
                    )
                )
        )
        //--------------------------Snackbar de error--------------------------------------

        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        )

        //--------------------------CONTENIDO DEL LOGIN--------------------------------------

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(horizontal = 66.dp), //paraque no se me alarguen hasta el final los textfields
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Logo
            Image(
                painter = painterResource(R.drawable.logo_seeshow_con_letra),
                contentDescription = stringResource(R.string.logo_seeshow),
                modifier = Modifier
                    .width(180.dp)
                    .height(85.dp)
            )

            Spacer(modifier = Modifier.height(28.dp))

            // titulo login
            Text(
                text = stringResource(R.string.login),
                color = TextWhite,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = stringResource(R.string.frase_registro_1),
                color = TextWhite,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(27.dp))


            // EMAIL
            OutlinedTextField(
                value = state.email,
                onValueChange = {
                    vm.onEmailChange(it)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                placeholder = {
                    Text(stringResource(R.string.email))
                },
                singleLine = true,
                isError = state.errorEmail != null,
                shape = RoundedCornerShape(4.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                )
            )

            // ERROR EMAIL
            if (state.errorEmail != null) {
                Text(
                    text = state.errorEmail ?: "",
                    color = SpoilerAccent,
                    fontSize = 10.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(13.dp))

            // CONTRASEÑA
            OutlinedTextField(
                value = state.contrasena,
                onValueChange = {
                    vm.onContraChange(it)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                placeholder = {
                    Text(stringResource(R.string.contraseña))
                },
                singleLine = true,
                isError = state.errorContra != null,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                shape = RoundedCornerShape(4.dp)
            )


            // ERROR CONTRASEÑA
            if (state.errorContra != null) {
                Text(
                    text = state.errorContra ?: "",
                    color = Color.Red,
                    fontSize = 10.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(7.dp))

            // RECUPERAR CONTRASEÑA
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {

                Text(
                    text = stringResource(R.string.frase_registro_2),
                    color = TextWhite,
                    fontSize = 10.sp
                )

                Text(
                    text = stringResource(R.string.clica_aqui),
                    color = Secondary,
                    fontSize = 10.sp
                )
            }

            Spacer(modifier = Modifier.height(7.dp))

            //--------------------------DropdownMenuBox--------------------------------------

            ExposedDropdownMenuBox(
                expanded = state.expanded,
                onExpandedChange = {
                    vm.onExpandedChange(it)
                }
            ) {

                OutlinedTextField(
                    value = state.tipoUsuario,
                    onValueChange = {},
                    readOnly = true,
                    label = {
                        Text("Tipo de usuario")
                    },
                    placeholder = {
                        Text("Selecciona tu tipo de cuenta")
                    },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(
                            expanded = state.expanded
                        )
                    },
                    modifier = Modifier
                        .menuAnchor(
                            ExposedDropdownMenuAnchorType.PrimaryNotEditable
                        )
                        .fillMaxWidth()
                )

                ExposedDropdownMenu(
                    expanded = state.expanded,
                    onDismissRequest = {
                        vm.onExpandedChange(false)
                    }
                ) {

                    listOf(
                        "Usuario",
                        "Creador de contenido",
                        "Crítico"
                    ).forEach { tipo ->

                        DropdownMenuItem(
                            text = {
                                Text(tipo)
                            },
                            onClick = {
                                vm.onTipoUsuarioChange(tipo)
                                vm.onExpandedChange(false)
                            }
                        )
                    }
                }
            }
            //----------------------------------------------------------------


            Spacer(modifier = Modifier.height(16.dp))

            // BOTÓN LOGIN
            Botones(
                enum = VarianteBoton.BASICO_ACTIVO,
                data = BotonData(
                    id = 1,
                    texto = stringResource(R.string.login),
                    onClic = {
                        if (vm.isError()) {
                            //snackbar
                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    message = "Campo incorrecto"
                                )
                            }

                        } else {
                            onLoginCorrecto()
                        }
                    }
                )
            )

            Spacer(modifier = Modifier.height(17.dp))

            // REGISTRO
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = stringResource(R.string.frase_registro_3),
                    color = TextWhite,
                    fontSize = 10.sp
                )

                Text(
                    text = stringResource(R.string.registrate),
                    color = Secondary,
                    fontSize = 10.sp
                )

                Text(
                    text = stringResource(R.string.aquí),
                    color = TextWhite,
                    fontSize = 10.sp
                )
            }
        }
    }
}


@Preview
@Composable
fun PantallaLogInPreview() {
    SeeShowTheme {
        Surface {
            PantallaLogIn(
                onLoginCorrecto = {}
            )
        }
    }
}