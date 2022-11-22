package com.example.simulaconcardiovascular.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Etapas")
data class Etapa(
    @PrimaryKey(autoGenerate = true)
    val etapaId: Int = 0,
    val descripcion: String
)