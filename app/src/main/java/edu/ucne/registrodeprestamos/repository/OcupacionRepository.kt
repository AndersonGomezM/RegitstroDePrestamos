package edu.ucne.registrodeprestamos.repository

import edu.ucne.registrodeprestamos.data.OcupacionDb
import edu.ucne.registrodeprestamos.data.entity.OcupacionEntity
import javax.inject.Inject

class OcupacionRepository @Inject constructor(val db: OcupacionDb) {

    suspend fun insertarOcupacion(ocupacion: OcupacionEntity) {
        db.ocupacionDao.insertarOcupacion(ocupacion)
    }

    suspend fun actualizarOcupacion(ocupacion: OcupacionEntity) {
        db.ocupacionDao.actualizarOcupacion(ocupacion)
    }

    suspend fun eliminarOcupacion(ocupacion: OcupacionEntity) {
        db.ocupacionDao.eliminarOcupacion(ocupacion)
    }

    fun getOcupacion(ocupacionId: Int) = db.ocupacionDao.getOcupacion(ocupacionId)

    fun getList() = db.ocupacionDao.getList()
}