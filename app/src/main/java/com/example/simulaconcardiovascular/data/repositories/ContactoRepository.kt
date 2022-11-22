package com.example.simulaconcardiovascular.data.repositories

import com.example.simulaconcardiovascular.data.daos.ContactoDao
import com.example.simulaconcardiovascular.model.Contacto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ContactoRepository @Inject constructor(
    val contactoDao: ContactoDao
) {
    suspend fun insertar(contacto: Contacto){
        contactoDao.insertar(contacto)
    }

    suspend fun eliminar(contacto: Contacto){
        contactoDao.eliminar(contacto)
    }

    fun buscar(contactoId: Int): Flow<List<Contacto>> {
        return contactoDao.buscar(contactoId)
    }

    fun getList(): Flow<List<Contacto>> {
        return contactoDao.getList()
    }
}