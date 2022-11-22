package com.example.simulaconcardiovascular.ui.components.etapas

import androidx.lifecycle.ViewModel
import com.example.simulaconcardiovascular.data.repositories.EtapaRepository
import com.example.simulaconcardiovascular.model.Etapa
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class EtapaViewModel @Inject constructor(
    val etapaRepository: EtapaRepository
): ViewModel() {

    var etapas = etapaRepository.getList()
        private set

    fun buscar(id: Int): Flow<List<Etapa>> {
        return etapaRepository.buscar(id)
    }
}