package com.example.simulaconcardiovascular

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.simulaconcardiovascular.ui.components.etapas.EtapaViewModel

fun validarPhone(telefono: String): Boolean {
    if(telefono.length != 10)
        return false
    return isNumeric(telefono)
}
fun isNumeric(texto: String): Boolean {
    return try {
        texto.toLong()
        true
    } catch (e: NumberFormatException) {
        false
    }
}


fun InicalNombre(inicial: String): String {
    var i = inicial[0]
    return i.toString().uppercase()
}

@Composable
fun getNombreEtapa(etapa: Int, viewModel: EtapaViewModel = hiltViewModel()): String {
    var name: String = ""
    val etapas = viewModel.etapas.collectAsState(initial = emptyList())

    etapas.value.forEach { element ->
        if (etapa == element.etapaId) {
            name = element.descripcion
        }
    }

    return name
}
