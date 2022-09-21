package edu.ucne.registrodeprestamos.repository

import edu.ucne.registrodeprestamos.data.PrestamoDb
import edu.ucne.registrodeprestamos.data.entity.PrestamoEntity
import javax.inject.Inject

class PrestamoRepository @Inject constructor(val db: PrestamoDb) {

    suspend fun insertarPrestamo(prestamo: PrestamoEntity) {
        db.prestamoDao.insertarPrestamo(prestamo)
    }

    suspend fun actualizarPrestamo(prestamo: PrestamoEntity) {
        db.prestamoDao.actualizarPrestamo(prestamo)
    }

    suspend fun eliminarPrestamo(prestamo: PrestamoEntity) {
        db.prestamoDao.eliminarPrestamo(prestamo)
    }

    fun getPrestamo(prestamoId: Int) = db.prestamoDao.getPrestamo(prestamoId)

    fun getList() = db.prestamoDao.getList()
}