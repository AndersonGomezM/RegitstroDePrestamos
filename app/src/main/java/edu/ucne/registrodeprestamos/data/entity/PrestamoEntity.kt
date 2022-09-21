package edu.ucne.registrodeprestamos.data.entity

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey

@Dao
@Entity(tableName = "Prestamos")
data class PrestamoEntity (
    @PrimaryKey(autoGenerate = true)
    val prestamoId: Int = 0,
    val fecha: String = "",
    val vence: String = "",
    val personaId: Int = 0,
    val concepto: String = "",
    val monto: Double = 0.0,
    val balance: Double
)