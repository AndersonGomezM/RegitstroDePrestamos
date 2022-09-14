package edu.ucne.registrodeprestamos.data.dao

import androidx.room.*
import edu.ucne.registrodeprestamos.data.entity.OcupacionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OcupacionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOcupacion(ocupacion: OcupacionEntity)

    @Update
    suspend fun updateOcupacion(ocupacion: OcupacionEntity)

    @Delete
    suspend fun deleteOcupacion(ocupacion: OcupacionEntity)

    @Query("SELECT * FROM Ocupaciones WHERE ocupacionId = :id")
    fun getOcupacion(id: Int): Flow<OcupacionEntity>

    @Query("SELECT * FROM Ocupaciones")
    fun getAll(): Flow<List <OcupacionEntity>>
}