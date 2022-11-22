package com.example.simulaconcardiovascular.ui.screens.diagnostico

import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.simulaconcardiovascular.ui.components.etapas.EtapaSpinner
import com.example.simulaconcardiovascular.ui.components.etapas.EtapaViewModel
import com.example.simulaconcardiovascular.utils.Screen


@Composable
fun DiagnosticoScreen(
    navController: NavController,
    viewModel: DiagnosticoViewModel = hiltViewModel()
) {
    var enfermedad by rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current

//    val listaTecnicos = viewModel.buscar(id).collectAsState(initial = emptyList())
//    listaTecnicos.value.forEach {
//        viewModel.nombreTecnico = it.nombreTecnico
//        viewModel.telefonoTecnico = it.telefonoTecnico
//        viewModel.email = it.email
//    }

    fun avisos(aviso: String) {
        Toast.makeText(
            context,
            aviso,
            Toast.LENGTH_SHORT
        ).show()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Diagnostico") }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .absolutePadding(16.dp, 16.dp, 16.dp, 16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            Spacer(modifier = Modifier.height(25.dp))

            EtapaSpinner();

            Spacer(modifier = Modifier.height(25.dp))


            OutlinedTextField(
                value = viewModel.pulso,
                onValueChange = {
                    viewModel.pulso = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text("Pulso Sanguíneo")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Bloodtype,
                        contentDescription = null
                    )
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words,
                    keyboardType = KeyboardType.Number
                )
            )

            //TextObligatorio(error = nombreError)

            Spacer(modifier = Modifier.height(25.dp))




            Spacer(modifier = Modifier.height(25.dp))

            Button(
                onClick = {
                    enfermedad = evaluacion(viewModel.etapaId, viewModel.pulso.toInt())
////                    nombreError = viewModel.nombreTecnico.isBlank()
////                    telefonoError = viewModel.telefonoTecnico.isBlank()
////                    emailError = viewModel.email.isBlank()
//                    if (!nombreError && !telefonoError && !emailError) {
//                        if (validarPhone(viewModel.telefonoTecnico)) {
//                            if (validarEmail(viewModel.email)) {
//                                viewModel.Guardar()
//                                avisos("Guardado")
//                                navController.navigateUp()
//
//                            } else {
//                                avisos("Email no valido")
//                            }
//                        } else {
//                            avisos("Telefono no Valido")
//                        }
//                    } else {
//                        avisos("Faltan Campos obligatorios")
//                    }


                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.MedicalInformation,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text("Evaluar pulso")
            }

            Spacer(modifier = Modifier.height(25.dp))
            Text(text = enfermedad)

        }

    }
}
/*
  Etapas  valor normal
  1 ---- 120 - 140
  2 ---- 110 - 130
  3 ---- 100 - 120
  4 ---- 80 - 100
  5 ---- 70 - 100
  6 ---- 60 - 100
  7 ---- 60 - 90
*/

fun evaluacion(etapaId: Int, pulso: Int): String {
    var mensaje : String = ""
    when (etapaId){
        1 ->{
            if(pulso < 120){
                mensaje = "Bradicardia"
            }
            if(pulso >= 120 && pulso <= 140){
                mensaje = "Pulso Normal"
            }
            if(pulso > 140){
                mensaje = "Taquicardia"
            }
        }
        2 ->{
            if(pulso < 110){
                mensaje = "Bradicardia"
            }
            if(pulso >= 110 && pulso <= 130){
                mensaje = "Pulso Normal"
            }
            if(pulso > 130){
                mensaje = "Taquicardia"
            }
        }
        3 ->{
            if(pulso < 100){
                mensaje = "Bradicardia"
            }
            if(pulso >= 100 && pulso <= 120){
                mensaje = "Pulso Normal"
            }
            if(pulso > 120){
                mensaje = "Taquicardia"
            }
        }
        4 ->{
            if(pulso < 80){
                mensaje = "Bradicardia"
            }
            if(pulso >= 80 && pulso <= 100){
                mensaje = "Pulso Normal"
            }
            if(pulso > 100){
                mensaje = "Taquicardia"
            }
        }
        5 ->{
            if(pulso < 70){
                mensaje = "Bradicardia"
            }
            if(pulso >= 70 && pulso <= 100){
                mensaje = "Pulso Normal"
            }
            if(pulso > 100){
                mensaje = "Taquicardia"
            }
        }
        6 ->{
            if(pulso < 60){
                mensaje = "Bradicardia"
            }
            if(pulso >= 60 && pulso <= 100){
                mensaje = "Pulso Normal"
            }
            if(pulso > 100){
                mensaje = "Taquicardia"
            }
        }
        7 ->{
            if(pulso < 60){
                mensaje = "Bradicardia"
            }
            if(pulso >=60 && pulso <=90){
                mensaje = "Pulso Normal"
            }
            if(pulso > 90){
                mensaje = "Taquicardia"
            }
        }

    }
    return mensaje
}