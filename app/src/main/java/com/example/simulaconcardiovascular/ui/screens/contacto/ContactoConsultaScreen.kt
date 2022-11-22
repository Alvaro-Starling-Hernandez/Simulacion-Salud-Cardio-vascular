package com.example.simulaconcardiovascular.ui.screens.contacto

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.simulaconcardiovascular.ui.components.ContactoItem
import com.example.simulaconcardiovascular.utils.Screen

@Composable
fun ContactoConsultaScreen(
    navController: NavController,
    viewModel: ContactoViewModel = hiltViewModel()
) {

    /*val searchWidgetState by viewModel.searchWidgetState
    val searchTextState by viewModel.searchTextState*/

    Scaffold (
        topBar = {

            TopAppBar(
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable {
                                navController.navigateUp()
                            }
                    )
                },
                title = { Text("Contactos de Emergencia") }
            )

        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.RegistroContacto.route)
                }
                ,
                modifier = Modifier.padding(bottom = 50.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.PersonAdd,
                    contentDescription = null
                )
            }
        }, floatingActionButtonPosition = FabPosition.End
    ){
        Column(
            modifier = Modifier
                .padding(it)
                .absolutePadding(5.dp, 5.dp, 5.dp, 64.dp)

        ) {

            val listaContactos = viewModel.contactos.collectAsState(initial = emptyList())

            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(listaContactos.value) { item ->
                    ContactoItem(item, navController)
                }
            }


        }
    }
}