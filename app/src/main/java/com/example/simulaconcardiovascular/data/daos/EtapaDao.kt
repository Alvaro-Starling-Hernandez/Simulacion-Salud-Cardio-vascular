package com.example.simulaconcardiovascular.data.daos

import androidx.room.*
import com.example.simulaconcardiovascular.model.Etapa
import kotlinx.coroutines.flow.Flow

@Dao
interface EtapaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(etapa: Etapa)

    @Delete
    suspend fun eliminar(etapa: Etapa)

    @Query("SELECT * FROM etapas WHERE etapaId =:etapaId")
    fun buscar(etapaId: Int): Flow<List<Etapa>>

    @Query("SELECT * FROM etapas ORDER BY etapaId")
    fun getList(): Flow<List<Etapa>>
}