package com.example.simulaconcardiovascular.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.simulaconcardiovascular.data.daos.ContactoDao
import com.example.simulaconcardiovascular.data.daos.EtapaDao
import com.example.simulaconcardiovascular.model.Contacto
import com.example.simulaconcardiovascular.model.Etapa

@Database(
    entities = [
        Etapa::class,
        Contacto::class
    ],
    exportSchema = false,
    version = 2
)
abstract class CardioDb : RoomDatabase() {
    abstract val etapaDao: EtapaDao
    abstract val contactoDao: ContactoDao
}
