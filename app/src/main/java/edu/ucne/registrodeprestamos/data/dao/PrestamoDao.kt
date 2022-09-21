package edu.ucne.registrodeprestamos.data.dao

import androidx.room.*
import edu.ucne.registrodeprestamos.data.entity.PrestamoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PrestamoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarPrestamo(prestamo: PrestamoEntity)

    @Update
    suspend fun actualizarPrestamo(prestamo: PrestamoEntity)

    @Delete
    suspend fun eliminarPrestamo(prestamo: PrestamoEntity)

    @Query("SELECT * " +
            "FROM Prestamos " +
            "WHERE prestamoId = :id " +
            "LIMIT 1")
    fun getPrestamo(id: Int): Flow<PrestamoEntity>

    @Query("SELECT * FROM Ocupaciones")
    fun getList(): Flow<List <PrestamoEntity>>
}