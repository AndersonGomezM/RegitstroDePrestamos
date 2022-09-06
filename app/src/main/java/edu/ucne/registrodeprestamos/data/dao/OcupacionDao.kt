package edu.ucne.registrodeprestamos.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import edu.ucne.registrodeprestamos.model.Ocupacion
import kotlinx.coroutines.flow.Flow

@Dao
interface OcupacionDao {
    @Insert
    suspend fun insertOcupacion(ocupacion: Ocupacion)

    @Update
    suspend fun updateOcupacion(ocupacion: Ocupacion)

    @Delete
    suspend fun deleteOcupacion(ocupacion: Ocupacion)

    @Query("SELECT * FROM Ocupaciones WHERE ocupacionId = :id")
    fun getOcupacion(id: Int): Flow<Ocupacion>

    @Query("SELECT * FROM Ocupaciones")
    fun getAll(): Flow<List <Ocupacion>>
}