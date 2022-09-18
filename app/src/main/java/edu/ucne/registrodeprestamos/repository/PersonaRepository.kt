package edu.ucne.registrodeprestamos.repository

import edu.ucne.registrodeprestamos.data.entity.PersonaEntity
import edu.ucne.registrodeprestamos.data.PersonaDb
import javax.inject.Inject

class PersonaRepository @Inject constructor(
    val db: PersonaDb
) {

    suspend fun insertarPersona(persona: PersonaEntity) {
        db.personaDao.insertarPersona(persona)
    }

    suspend fun actualizarPersona(persona: PersonaEntity) {
        db.personaDao.actualizarPersona(persona)
    }

    suspend fun eliminarPersona(persona: PersonaEntity) {
        db.personaDao.eliminarPersona(persona)
    }

    fun getPersona(personaId: Int) = db.personaDao.getPersona(personaId)

    fun getList() = db.personaDao.getList()
}