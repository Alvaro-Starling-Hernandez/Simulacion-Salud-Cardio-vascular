package com.example.simulaconcardiovascular.ui.screens.contacto

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simulaconcardiovascular.data.repositories.ContactoRepository
import com.example.simulaconcardiovascular.model.Contacto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactoViewModel @Inject constructor(
    val contactoRepository: ContactoRepository
): ViewModel(){
    var nombre by mutableStateOf("")
    var telefono by mutableStateOf("")
    var idContacto by mutableStateOf(0)

    var contactos = contactoRepository.getList()
        private set

    fun Guardar() {
        viewModelScope.launch {
            contactoRepository.insertar(
                Contacto(
                    nombreContacto = nombre,
                    telefonoContacto = telefono,
                    contactoId = idContacto
                )
            )
        }
    }

    fun eliminar(contacto: Contacto) {
        viewModelScope.launch {
            contactoRepository.eliminar(contacto)
        }
    }

    fun buscar(id: Int): Flow<List<Contacto>> {
        return contactoRepository.buscar(id)
    }

//    private val _searchWidgetState: MutableState<SearchWidgetState> =
//        mutableStateOf(value = SearchWidgetState.CLOSED)
//    val searchWidgetState: State<SearchWidgetState> = _searchWidgetState
//
//    private val _searchTextState: MutableState<String> =
//        mutableStateOf(value = "")
//    val searchTextState: State<String> = _searchTextState
//
//    fun updateSearchWidgetState(newValue: SearchWidgetState) {
//        _searchWidgetState.value = newValue
//    }
//
//    fun updateSearchTextState(newValue: String) {
//        _searchTextState.value = newValue
//    }
}