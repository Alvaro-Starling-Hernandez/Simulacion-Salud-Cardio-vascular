package com.example.simulaconcardiovascular.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.*
import com.example.simulaconcardiovascular.model.Contacto
import kotlinx.coroutines.flow.Flow
@Dao
interface ContactoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(contacto: Contacto)

    @Delete
    suspend fun eliminar(contacto: Contacto)

    @Query("SELECT * FROM contactos WHERE contactoId=:contactoId")
    fun buscar(contactoId: Int): Flow<List<Contacto>>

    @Query("SELECT * FROM contactos ORDER BY contactoId")
    fun getList(): Flow<List<Contacto>>
}