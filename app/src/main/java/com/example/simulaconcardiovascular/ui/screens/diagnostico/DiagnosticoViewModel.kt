package com.example.simulaconcardiovascular.ui.screens.diagnostico


import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiagnosticoViewModel @Inject constructor(
//    val ticketRepository: TicketRepository
): ViewModel() {
    var pulso by mutableStateOf("")
    var etapaId by mutableStateOf(0)
}