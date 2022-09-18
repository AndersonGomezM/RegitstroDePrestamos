package edu.ucne.registrodeprestamos.data.dao

import androidx.room.*
import edu.ucne.registrodeprestamos.data.entity.PersonaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarPersona(ocupacion: PersonaEntity)

    @Update
    suspend fun actualizarPersona(ocupacion: PersonaEntity)

    @Delete
    suspend fun eliminarPersona(ocupacion: PersonaEntity)

    @Query("SELECT * " +
            "FROM Personas " +
            "WHERE personaId = :id " +
            "LIMIT 1")
    fun getPersona(id: Int): Flow<PersonaEntity>

    @Query("SELECT * FROM Personas")
    fun getList(): Flow<List <PersonaEntity>>
}