package edu.ucne.registrodeprestamos.data.entity

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey

@Dao
@Entity(tableName = "Personas")
data class PersonaEntity (
    @PrimaryKey(autoGenerate = true)
    val personaId: Int = 0,
    val nombre: String = "",
    val telefono: String = "",
    val celular: String = "",
    val email: String = "",
    val direccion: String = "",
    val fechaNacimiento: String = "",
    val ocupacioId: Int
)