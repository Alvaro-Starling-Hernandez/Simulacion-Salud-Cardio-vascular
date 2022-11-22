package com.example.simulaconcardiovascular.ui.components.etapas

import androidx.compose.foundation.clickable
import com.example.simulaconcardiovascular.getNombreEtapa

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.toSize
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.simulaconcardiovascular.ui.screens.diagnostico.DiagnosticoViewModel

@Composable
fun EtapaSpinner(
//    idEtapa: Int = 1,
    viewModel: EtapaViewModel = hiltViewModel(),
    diagnosticoViewModel: DiagnosticoViewModel = hiltViewModel()
) {

//    var writeNameEtapa: String
//
//    writeNameEtapa = getNombreEtapa(idEtapa)

    var mExpanded by remember { mutableStateOf(false) }

    val etapas = viewModel.etapas.collectAsState(initial = emptyList())

    var mSelectedText by remember {
        mutableStateOf("")
    }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (mExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown


    Column(
        Modifier
            .clickable { mExpanded = !mExpanded }
            .fillMaxWidth()
    ) {

        OutlinedTextField(
            value = mSelectedText,
            onValueChange = { mSelectedText = it },
            modifier = Modifier
                .clickable { mExpanded = !mExpanded }
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    mTextFieldSize = coordinates.size.toSize()
                },
            label = { Text("Etapa de vida") },
            trailingIcon = {
                Icon(
                    icon,
                    null,
                    Modifier.clickable { mExpanded = !mExpanded }
                )
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = null)
            },
            readOnly = true,
            singleLine = true
        )
        DropdownMenu(
            expanded = mExpanded,
            onDismissRequest = { mExpanded = false },
            modifier = Modifier.width(with(LocalDensity.current) { mTextFieldSize.width.toDp() })
        ) {
            etapas.value.forEach {
                DropdownMenuItem(onClick = {
                    diagnosticoViewModel.etapaId = it.etapaId
                    mSelectedText = it.descripcion
                    mExpanded = false
                }) {
                    Text(text = it.descripcion)
                }
            }
        }
    }
}
