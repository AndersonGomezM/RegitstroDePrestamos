package edu.ucne.registrodeprestamos.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.ucne.registrodeprestamos.data.dao.OcupacionDao
import edu.ucne.registrodeprestamos.data.Entity.OcupacionEntity

@Database(
    version = 1,
    entities = [OcupacionEntity::class],
    exportSchema = false
)

abstract class PrestamosDb : RoomDatabase() {
    abstract val ocupacionDao: OcupacionDao

    companion object{

        @Volatile
        private var INSTANCE: PrestamosDb? = null

        fun getInstance(context: Context): PrestamosDb {
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PrestamosDb::class.java,
                        "Prestamos.db"
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