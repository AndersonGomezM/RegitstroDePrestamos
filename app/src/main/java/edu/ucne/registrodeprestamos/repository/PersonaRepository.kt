package edu.ucne.registrodeprestamos.repository

import edu.ucne.registrodeprestamos.data.entity.PersonaEntity
import edu.ucne.registrodeprestamos.data.PersonaDb
import javax.inject.Inject

class PersonaRepository @Inject constructor(val db: PersonaDb) {

    suspend fun insertPersona(persona: PersonaEntity) {
        db.personaDao.insertPersona(persona)
    }

    suspend fun updatePersona(persona: PersonaEntity) {
        db.personaDao.updatePersona(persona)
    }

    suspend fun deletePersona(persona: PersonaEntity) {
        db.personaDao.deletePersona(persona)
    }

    fun getPersona(personaId: Int) = db.personaDao.getPersona(personaId)

    fun getAll() = db.personaDao.getAll()
}