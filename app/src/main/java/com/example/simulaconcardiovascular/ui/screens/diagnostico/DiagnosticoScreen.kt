package com.example.simulaconcardiovascular.ui.screens.diagnostico

import android.content.Intent
import android.net.Uri
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.simulaconcardiovascular.ui.components.etapas.EtapaSpinner
import com.example.simulaconcardiovascular.ui.components.etapas.EtapaViewModel
import com.example.simulaconcardiovascular.ui.screens.contacto.ContactoViewModel
import com.example.simulaconcardiovascular.utils.Screen


@Composable
fun DiagnosticoScreen(
    navController: NavController,
    viewModel: DiagnosticoViewModel = hiltViewModel(),
    contactoViewModel: ContactoViewModel = hiltViewModel()

) {
    var enfermedad by rememberSaveable { mutableStateOf("") }
    var recomendacion by rememberSaveable { mutableStateOf("") }
    var telefono by rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current

    val listaDeContactos = contactoViewModel.buscar(1).collectAsState(initial = emptyList())
    listaDeContactos.value.forEach {
       telefono = it.telefonoContacto
    }

    fun avisos(aviso: String) {
        Toast.makeText(
            context, aviso, Toast.LENGTH_SHORT
        ).show()
    }

    Scaffold(topBar = {
        TopAppBar(title = { Text("Diagnostico") })
    }) {
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


            OutlinedTextField(value = viewModel.pulso, onValueChange = {
                viewModel.pulso = it
            }, modifier = Modifier.fillMaxWidth(), label = {
                Text("Pulso Sanguíneo")
            }, leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Bloodtype, contentDescription = null
                )
            }, singleLine = true, keyboardOptions = KeyboardOptions(
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
                    if (enfermedad == "Taquicardia" && viewModel.etapaId == 1) {
                        recomendacion = "T1"
                        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$telefono"))
                        context.startActivity(intent)
                    }
                    if (enfermedad == "Pulso Normal" && viewModel.etapaId == 1) {
                        recomendacion = "P1"
                    }
                    if (enfermedad == "Bradicardia" && viewModel.etapaId == 1) {
                        recomendacion = "B1"
                    }
                    if (enfermedad == "Taquicardia" && viewModel.etapaId == 2) {
                        recomendacion = "T2"
                        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$telefono"))
                        context.startActivity(intent)
                    }
                    if (enfermedad == "Pulso Normal" && viewModel.etapaId == 2) {
                        recomendacion = "P2"
                    }
                    if (enfermedad == "Bradicardia" && viewModel.etapaId == 2) {
                        recomendacion = "B2"
                    }
                    if (enfermedad == "Taquicardia" && viewModel.etapaId == 3) {
                        recomendacion = "T3"
                        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$telefono"))
                        context.startActivity(intent)
                    }
                    if (enfermedad == "Pulso Normal" && viewModel.etapaId == 3) {
                        recomendacion = "P3"
                    }
                    if (enfermedad == "Bradicardia" && viewModel.etapaId == 3) {
                        recomendacion = "B3"
                    }
                    if (enfermedad == "Taquicardia" && viewModel.etapaId == 4) {
                        recomendacion = "T4"
                        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$telefono"))
                        context.startActivity(intent)
                    }
                    if (enfermedad == "Pulso Normal" && viewModel.etapaId == 4) {
                        recomendacion = "P4"
                    }
                    if (enfermedad == "Bradicardia" && viewModel.etapaId == 4) {
                        recomendacion = "B4"
                    }
                    if (enfermedad == "Taquicardia" && viewModel.etapaId == 5) {
                        recomendacion = "T5"
                        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$telefono"))
                        context.startActivity(intent)
                    }
                    if (enfermedad == "Pulso Normal" && viewModel.etapaId == 5) {
                        recomendacion = "P5"
                    }
                    if (enfermedad == "Bradicardia" && viewModel.etapaId == 5) {
                        recomendacion = "B5"
                    }
                    if (enfermedad == "Taquicardia" && viewModel.etapaId == 6) {
                        recomendacion = "T6"
                        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$telefono"))
                        context.startActivity(intent)
                    }
                    if (enfermedad == "Pulso Normal" && viewModel.etapaId == 6) {
                        recomendacion = "P6"
                    }
                    if (enfermedad == "Bradicardia" && viewModel.etapaId == 6) {
                        recomendacion = "B6"
                    }
                    if (enfermedad == "Taquicardia" && viewModel.etapaId == 7) {
                        recomendacion = "T7"
                        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$telefono"))
                        context.startActivity(intent)
                    }
                    if (enfermedad == "Pulso Normal" && viewModel.etapaId == 7) {
                        recomendacion = "P7"
                    }
                    if (enfermedad == "Bradicardia" && viewModel.etapaId == 7) {
                        recomendacion = "B7"
                    }
                }, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.MedicalInformation, contentDescription = null
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text("Evaluar pulso")
            }

            Spacer(modifier = Modifier.height(15.dp))
            if (recomendacion == "T1") {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Medication,
                        contentDescription = null,
                        tint = Color.Red,
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        "Taquicardia en Recien Nacido",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6,
                    )
                    Text(
                        text = "Expertos recomiendan acudir a una visita medica con el pediatra por los siguientes factores: ",
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        "En el tratamiento de la taquicardia con compromiso hemodinámico, es prioritaria la cardioversión eléctrica. Por el contrario, si es bien tolerada, se plantea un tratamiento escalonado, con maniobras vagotónicas inicialmente y, si no responde, se inicia el tratamiento farmacológico con adenosina (0,03-0,25mg/kg) o ATP (0,05-0,1mg/kg), que producen un bloqueo transitorio del nodo aurículo-ventricular6,7. Si no hay respuesta a estos fármacos, se pueden administrar amiodarona, betabloqueantes o digoxina.",
                    )

                }

            }
            if (recomendacion == "P1") {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.HowToReg,
                        contentDescription = null,
                        tint = Color.Green,
                        modifier = Modifier.size(150.dp)
                    )
                    Text(
                        "Pulso Normal",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6,
                    )
                    Text(
                        text = "El pulso del recien nacido esta dentro de los varoles estandar que son: 120 - 140",
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Center
                    )

                }

            }
            if (recomendacion == "B1") {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Medication,
                        contentDescription = null,
                        tint = Color.Red,
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        "Bradicardia en Recien Nacido",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6,
                    )
                    Text(
                        text = "Expertos recomiendan acudir a una visita medica con el pediatra por los siguientes factores: ",
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        "Se admite que una frecuencia cardiaca por debajo de 120 latidos por minuto es bradicardia”, expone Javier Jiménez Candil, presidente de la Asociación del Ritmo Cardiaco de la Sociedad Española de Cardiología (SEC), aunque matiza que, probablemente, “si utilizamos el punto de corte de 50, encontraríamos un entorno en el que la bradicardia tiene más significación patológica”."
                    )

                }

            }
            //bebe
            if (recomendacion == "T2") {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Medication,
                        contentDescription = null,
                        tint = Color.Red,
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        "Taquicardia en Bebe",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6,
                    )
                    Text(
                        text = "Expertos recomiendan acudir a una visita medica con el pediatra por los siguientes factores: ",
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        "En el tratamiento de la taquicardia con compromiso hemodinámico, es prioritaria la cardioversión eléctrica. Por el contrario, si es bien tolerada, se plantea un tratamiento escalonado, con maniobras vagotónicas inicialmente y, si no responde, se inicia el tratamiento farmacológico con adenosina (0,03-0,25mg/kg) o ATP (0,05-0,1mg/kg), que producen un bloqueo transitorio del nodo aurículo-ventricular6,7. Si no hay respuesta a estos fármacos, se pueden administrar amiodarona, betabloqueantes o digoxina.",
                    )

                }

            }
            if (recomendacion == "P2") {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.HowToReg,
                        contentDescription = null,
                        tint = Color.Green,
                        modifier = Modifier.size(150.dp)
                    )
                    Text(
                        "Pulso Normal",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6,
                    )
                    Text(
                        text = "El pulso del bebe esta dentro de los varoles estandar que son: 110 - 130",
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Center
                    )

                }

            }
            if (recomendacion == "B2") {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Medication,
                        contentDescription = null,
                        tint = Color.Red,
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        "Bradicardia en Bebe",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6,
                    )
                    Text(
                        text = "Expertos recomiendan acudir a una visita medica con el pediatra por los siguientes factores: ",
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        "“Se admite que una frecuencia cardiaca por debajo de 110 latidos por minuto es bradicardia”, expone Javier Jiménez Candil, presidente de la Asociación del Ritmo Cardiaco de la Sociedad Española de Cardiología (SEC), aunque matiza que, probablemente, “si utilizamos el punto de corte de 50, encontraríamos un entorno en el que la bradicardia tiene más significación patológica”."
                    )

                }

            }
            //infante
            if (recomendacion == "T3") {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Medication,
                        contentDescription = null,
                        tint = Color.Red,
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        "Taquicardia en Infante",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6,
                    )
                    Text(
                        text = "Expertos recomiendan acudir a una visita medica con el pediatra por los siguientes factores: ",
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        "En el tratamiento de la taquicardia con compromiso hemodinámico, es prioritaria la cardioversión eléctrica. Por el contrario, si es bien tolerada, se plantea un tratamiento escalonado, con maniobras vagotónicas inicialmente y, si no responde, se inicia el tratamiento farmacológico con adenosina (0,03-0,25mg/kg) o ATP (0,05-0,1mg/kg), que producen un bloqueo transitorio del nodo aurículo-ventricular6,7. Si no hay respuesta a estos fármacos, se pueden administrar amiodarona, betabloqueantes o digoxina.",
                    )

                }

            }
            if (recomendacion == "P3") {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.HowToReg,
                        contentDescription = null,
                        tint = Color.Green,
                        modifier = Modifier.size(150.dp)
                    )
                    Text(
                        "Pulso Normal",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6,
                    )
                    Text(
                        text = "El pulso del Infante esta dentro de los varoles estandar que son: 100 - 120",
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Center
                    )

                }

            }
            if (recomendacion == "B3") {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Medication,
                        contentDescription = null,
                        tint = Color.Red,
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        "Bradicardia en Infante",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6,
                    )
                    Text(
                        text = "Expertos recomiendan acudir a una visita medica con el pediatra por los siguientes factores: ",
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        "“Se admite que una frecuencia cardiaca por debajo de 100 latidos por minuto es bradicardia”, expone Javier Jiménez Candil, presidente de la Asociación del Ritmo Cardiaco de la Sociedad Española de Cardiología (SEC), aunque matiza que, probablemente, “si utilizamos el punto de corte de 50, encontraríamos un entorno en el que la bradicardia tiene más significación patológica”."
                    )

                }

            }
            //Nino
            if (recomendacion == "T4") {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Medication,
                        contentDescription = null,
                        tint = Color.Red,
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        "Taquicardia en Niño",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6,
                    )
                    Text(
                        text = "Expertos recomiendan acudir a una visita medica con el pediatra por los siguientes factores: ",
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        "En el tratamiento de la taquicardia con compromiso hemodinámico, es prioritaria la cardioversión eléctrica. Por el contrario, si es bien tolerada, se plantea un tratamiento escalonado, con maniobras vagotónicas inicialmente y, si no responde, se inicia el tratamiento farmacológico con adenosina (0,03-0,25mg/kg) o ATP (0,05-0,1mg/kg), que producen un bloqueo transitorio del nodo aurículo-ventricular6,7. Si no hay respuesta a estos fármacos, se pueden administrar amiodarona, betabloqueantes o digoxina.",
                    )

                }

            }
            if (recomendacion == "P4") {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.HowToReg,
                        contentDescription = null,
                        tint = Color.Green,
                        modifier = Modifier.size(150.dp)
                    )
                    Text(
                        "Pulso Normal",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6,
                    )
                    Text(
                        text = "El pulso del Niño esta dentro de los varoles estandar que son: 80 - 100",
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Center
                    )

                }

            }
            if (recomendacion == "B4") {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Medication,
                        contentDescription = null,
                        tint = Color.Red,
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        "Bradicardia en Niño",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6,
                    )
                    Text(
                        text = "Expertos recomiendan acudir a una visita medica con el pediatra por los siguientes factores: ",
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        "“En general, se admite que una frecuencia cardiaca por debajo de 80 latidos por minuto es bradicardia”, expone Javier Jiménez Candil, presidente de la Asociación del Ritmo Cardiaco de la Sociedad Española de Cardiología (SEC), aunque matiza que, probablemente, “si utilizamos el punto de corte de 50, encontraríamos un entorno en el que la bradicardia tiene más significación patológica”."
                    )

                }

            }
            //adolescente
            if (recomendacion == "T5") {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Medication,
                        contentDescription = null,
                        tint = Color.Red,
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        "Taquicardia en Adolescente",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6,
                    )
                    Text(
                        text = "Expertos recomiendan acudir a una visita medica con el pediatra por los siguientes factores: ",
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        "En el tratamiento de la taquicardia con compromiso hemodinámico, es prioritaria la cardioversión eléctrica. Por el contrario, si es bien tolerada, se plantea un tratamiento escalonado, con maniobras vagotónicas inicialmente y, si no responde, se inicia el tratamiento farmacológico con adenosina (0,03-0,25mg/kg) o ATP (0,05-0,1mg/kg), que producen un bloqueo transitorio del nodo aurículo-ventricular6,7. Si no hay respuesta a estos fármacos, se pueden administrar amiodarona, betabloqueantes o digoxina.",
                    )

                }

            }
            if (recomendacion == "P5") {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.HowToReg,
                        contentDescription = null,
                        tint = Color.Green,
                        modifier = Modifier.size(150.dp)
                    )
                    Text(
                        "Pulso Normal",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6,
                    )
                    Text(
                        text = "El pulso del adolescente esta dentro de los varoles estandar que son: 70 - 100",
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Center
                    )

                }

            }
            if (recomendacion == "B5") {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Medication,
                        contentDescription = null,
                        tint = Color.Red,
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        "Bradicardia en Adolescente",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6,
                    )
                    Text(
                        text = "Expertos recomiendan acudir a una visita medica con el pediatra por los siguientes factores: ",
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        "“En general, se admite que una frecuencia cardiaca por debajo de 70 latidos por minuto es bradicardia”, expone Javier Jiménez Candil, presidente de la Asociación del Ritmo Cardiaco de la Sociedad Española de Cardiología (SEC), aunque matiza que, probablemente, “si utilizamos el punto de corte de 50, encontraríamos un entorno en el que la bradicardia tiene más significación patológica”."
                    )

                }

            }
            //Adultos
            if (recomendacion == "T6") {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Medication,
                        contentDescription = null,
                        tint = Color.Red,
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        "Taquicardia en Adulto",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6,
                    )
                    Text(
                        text = "Expertos recomiendan acudir a una visita medica con el pediatra por los siguientes factores: ",
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        "En el tratamiento de la taquicardia con compromiso hemodinámico, es prioritaria la cardioversión eléctrica. Por el contrario, si es bien tolerada, se plantea un tratamiento escalonado, con maniobras vagotónicas inicialmente y, si no responde, se inicia el tratamiento farmacológico con adenosina (0,03-0,25mg/kg) o ATP (0,05-0,1mg/kg), que producen un bloqueo transitorio del nodo aurículo-ventricular6,7. Si no hay respuesta a estos fármacos, se pueden administrar amiodarona, betabloqueantes o digoxina.",
                    )

                }

            }
            if (recomendacion == "P6") {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.HowToReg,
                        contentDescription = null,
                        tint = Color.Green,
                        modifier = Modifier.size(150.dp)
                    )
                    Text(
                        "Pulso Normal",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6,
                    )
                    Text(
                        text = "El pulso del adulto esta dentro de los varoles estandar que son: 60 - 100",
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Center
                    )

                }

            }
            if (recomendacion == "B6") {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Medication,
                        contentDescription = null,
                        tint = Color.Red,
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        "Bradicardia en Adulto",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6,
                    )
                    Text(
                        text = "Expertos recomiendan acudir a una visita medica con el pediatra por los siguientes factores: ",
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        "“En general, se admite que una frecuencia cardiaca por debajo de 60 latidos por minuto es bradicardia”, expone Javier Jiménez Candil, presidente de la Asociación del Ritmo Cardiaco de la Sociedad Española de Cardiología (SEC), aunque matiza que, probablemente, “si utilizamos el punto de corte de 50, encontraríamos un entorno en el que la bradicardia tiene más significación patológica”."
                    )

                }

            }
            //Adultos Mayor
            if (recomendacion == "T7") {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Medication,
                        contentDescription = null,
                        tint = Color.Red,
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        "Taquicardia en Adulto Mayor (Peligro)",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6,
                    )
                    Text(
                        text = "Expertos recomiendan acudir a una visita medica con el pediatra por los siguientes factores: ",
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        "En el tratamiento de la taquicardia con compromiso hemodinámico, es prioritaria la cardioversión eléctrica. Por el contrario, si es bien tolerada, se plantea un tratamiento escalonado, con maniobras vagotónicas inicialmente y, si no responde, se inicia el tratamiento farmacológico con adenosina (0,03-0,25mg/kg) o ATP (0,05-0,1mg/kg), que producen un bloqueo transitorio del nodo aurículo-ventricular6,7. Si no hay respuesta a estos fármacos, se pueden administrar amiodarona, betabloqueantes o digoxina.",
                    )

                }

            }
            if (recomendacion == "P7") {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.HowToReg,
                        contentDescription = null,
                        tint = Color.Green,
                        modifier = Modifier.size(150.dp)
                    )
                    Text(
                        "Pulso Normal",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6,
                    )
                    Text(
                        text = "El pulso del adulto mayor esta dentro de los varoles estandar que son: 60 - 90",
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Center
                    )

                }

            }
            if (recomendacion == "B7") {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Medication,
                        contentDescription = null,
                        tint = Color.Red,
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        "Bradicardia en Adulto Mayor",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6,
                    )
                    Text(
                        text = "Expertos recomiendan acudir a una visita medica con el pediatra por los siguientes factores: ",
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        "“En general, se admite que una frecuencia cardiaca por debajo de 60 latidos por minuto es bradicardia”, expone Javier Jiménez Candil, presidente de la Asociación del Ritmo Cardiaco de la Sociedad Española de Cardiología (SEC), aunque matiza que, probablemente, “si utilizamos el punto de corte de 50, encontraríamos un entorno en el que la bradicardia tiene más significación patológica”."
                    )

                }

            }

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
    var mensaje: String = ""
    when (etapaId) {
        1 -> {
            if (pulso < 120) {
                mensaje = "Bradicardia"
            }
            if (pulso >= 120 && pulso <= 140) {
                mensaje = "Pulso Normal"
            }
            if (pulso > 140) {
                mensaje = "Taquicardia"
            }
        }
        2 -> {
            if (pulso < 110) {
                mensaje = "Bradicardia"
            }
            if (pulso >= 110 && pulso <= 130) {
                mensaje = "Pulso Normal"
            }
            if (pulso > 130) {
                mensaje = "Taquicardia"
            }
        }
        3 -> {
            if (pulso < 100) {
                mensaje = "Bradicardia"
            }
            if (pulso >= 100 && pulso <= 120) {
                mensaje = "Pulso Normal"
            }
            if (pulso > 120) {
                mensaje = "Taquicardia"
            }
        }
        4 -> {
            if (pulso < 80) {
                mensaje = "Bradicardia"
            }
            if (pulso >= 80 && pulso <= 100) {
                mensaje = "Pulso Normal"
            }
            if (pulso > 100) {
                mensaje = "Taquicardia"
            }
        }
        5 -> {
            if (pulso < 70) {
                mensaje = "Bradicardia"
            }
            if (pulso >= 70 && pulso <= 100) {
                mensaje = "Pulso Normal"
            }
            if (pulso > 100) {
                mensaje = "Taquicardia"
            }
        }
        6 -> {
            if (pulso < 60) {
                mensaje = "Bradicardia"
            }
            if (pulso >= 60 && pulso <= 100) {
                mensaje = "Pulso Normal"
            }
            if (pulso > 100) {
                mensaje = "Taquicardia"
            }
        }
        7 -> {
            if (pulso < 60) {
                mensaje = "Bradicardia"
            }
            if (pulso >= 60 && pulso <= 90) {
                mensaje = "Pulso Normal"
            }
            if (pulso > 90) {
                mensaje = "Taquicardia"
            }
        }

    }
    return mensaje
}