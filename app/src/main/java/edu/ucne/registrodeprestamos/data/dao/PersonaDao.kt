package edu.ucne.registrodeprestamos.data.dao

import androidx.room.*
import edu.ucne.registrodeprestamos.data.entity.PersonaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPersona(ocupacion: PersonaEntity)

    @Update
    suspend fun updatePersona(ocupacion: PersonaEntity)

    @Delete
    suspend fun deletePersona(ocupacion: PersonaEntity)

    @Query("SELECT * FROM Personas WHERE PersonaId = :id")
    fun getPersona(id: Int): Flow<PersonaEntity>

    @Query("SELECT * FROM Personas")
    fun getAll(): Flow<List <PersonaEntity>>
}