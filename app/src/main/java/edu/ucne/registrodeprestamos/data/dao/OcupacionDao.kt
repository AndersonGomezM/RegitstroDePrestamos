package edu.ucne.registrodeprestamos.data.dao

import androidx.room.*
import edu.ucne.registrodeprestamos.data.entity.OcupacionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OcupacionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarOcupacion(ocupacion: OcupacionEntity)

    @Update
    suspend fun actualizarOcupacion(ocupacion: OcupacionEntity)

    @Delete
    suspend fun eliminarOcupacion(ocupacion: OcupacionEntity)

    @Query("SELECT * " +
            "FROM Ocupaciones " +
            "WHERE ocupacionId = :id " +
            "LIMIT 1")
    fun getOcupacion(id: Int): Flow<OcupacionEntity>

    @Query("SELECT * FROM Ocupaciones")
    fun getList(): Flow<List <OcupacionEntity>>
}