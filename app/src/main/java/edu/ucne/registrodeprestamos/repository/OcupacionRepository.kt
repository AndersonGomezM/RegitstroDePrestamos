package edu.ucne.registrodeprestamos.repository

import edu.ucne.registrodeprestamos.data.OcupacionDb
import edu.ucne.registrodeprestamos.data.entity.OcupacionEntity
import javax.inject.Inject

class OcupacionRepository @Inject constructor(val db: OcupacionDb) {

    suspend fun insertOcupacion(ocupacion: OcupacionEntity) {
        db.ocupacionDao.insertOcupacion(ocupacion)
    }

    suspend fun updateOcupacion(ocupacion: OcupacionEntity) {
        db.ocupacionDao.updateOcupacion(ocupacion)
    }

    suspend fun deleteOcupacion(ocupacion: OcupacionEntity) {
        db.ocupacionDao.deleteOcupacion(ocupacion)
    }

    fun getOcupacion(ocupacionId: Int) = db.ocupacionDao.getOcupacion(ocupacionId)

    fun getAll() = db.ocupacionDao.getAll()
}