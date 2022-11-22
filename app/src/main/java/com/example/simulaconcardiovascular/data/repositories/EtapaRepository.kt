package com.example.simulaconcardiovascular.data.repositories

import com.example.simulaconcardiovascular.data.daos.EtapaDao
import com.example.simulaconcardiovascular.model.Etapa
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EtapaRepository @Inject constructor(
    val etapaDao: EtapaDao
){
    suspend fun insertar(etapa: Etapa){
        etapaDao.insertar(etapa)
    }

    suspend fun eliminar(etapa: Etapa){
        etapaDao.eliminar(etapa)
    }

    fun buscar(etapaId: Int): Flow<List<Etapa>> {
        return etapaDao.buscar(etapaId)
    }

    fun getList(): Flow<List<Etapa>> {
        return etapaDao.getList()
    }
}