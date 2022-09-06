package edu.ucne.registrodeprestamos.data

import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomDatabase
import edu.ucne.registrodeprestamos.data.dao.OcupacionDao
import edu.ucne.registrodeprestamos.model.Ocupacion

@Database(
    entities = [Ocupacion::class],
    version = 2
)

abstract class AppDataBase : RoomDatabase() {
    abstract val ocupacionDao: OcupacionDao
}