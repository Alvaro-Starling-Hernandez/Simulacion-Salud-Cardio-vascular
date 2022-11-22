package com.example.simulaconcardiovascular.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contactos")
data class Contacto (
    @PrimaryKey(autoGenerate = true)
    val contactoId: Int=0,
    val nombreContacto: String,
    val telefonoContacto: String
)