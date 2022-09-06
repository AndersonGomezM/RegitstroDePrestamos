package edu.ucne.registrodeprestamos.repository

import edu.ucne.registrodeprestamos.data.AppDataBase
import edu.ucne.registrodeprestamos.data.dao.OcupacionDao
import edu.ucne.registrodeprestamos.model.Ocupacion
import javax.inject.Inject

class OcupacionRepository @Inject constructor(val db: AppDataBase) {

    suspend fun insertOcupacion(ocupacion: Ocupacion) {
        db.ocupacionDao.insertOcupacion(ocupacion)
    }

    suspend fun updateOcupacion(ocupacion: Ocupacion) {
        db.ocupacionDao.updateOcupacion(ocupacion)
    }

    suspend fun deleteOcupacion(ocupacion: Ocupacion) {
        db.ocupacionDao.deleteOcupacion(ocupacion)
    }

    fun getOcupacion(id: Int) = db.ocupacionDao.getOcupacion(id)

    fun getAll() = db.ocupacionDao.getAll()
}