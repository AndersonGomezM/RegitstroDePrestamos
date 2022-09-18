package edu.ucne.registrodeprestamos.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.ucne.registrodeprestamos.data.dao.PersonaDao
import edu.ucne.registrodeprestamos.data.entity.PersonaEntity

@Database(
    version = 2,
    entities = [PersonaEntity::class],
    exportSchema = false
)

abstract class PersonaDb : RoomDatabase() {
    abstract val personaDao: PersonaDao

    companion object{

        @Volatile
        private var INSTANCE: PersonaDb? = null

        fun getInstance(context: Context): PersonaDb {
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PersonaDb::class.java,
                        "Personas"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}