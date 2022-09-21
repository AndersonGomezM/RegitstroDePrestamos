package edu.ucne.registrodeprestamos.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.ucne.registrodeprestamos.data.dao.PrestamoDao
import edu.ucne.registrodeprestamos.data.entity.PrestamoEntity

@Database(
    version = 3,
    entities = [PrestamoEntity::class],
    exportSchema = false
)

abstract class PrestamoDb : RoomDatabase() {
    abstract val prestamoDao: PrestamoDao

    companion object{

        @Volatile
        private var INSTANCE: PrestamoDb? = null

        fun getInstance(context: Context): PrestamoDb {
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PrestamoDb::class.java,
                        "Prestamos"
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