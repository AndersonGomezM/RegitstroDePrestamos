package edu.ucne.registrodeprestamos.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.ucne.registrodeprestamos.data.dao.OcupacionDao
import edu.ucne.registrodeprestamos.data.entity.OcupacionEntity

@Database(
    version = 1,
    entities = [OcupacionEntity::class],
    exportSchema = false
)

abstract class OcupacionDb : RoomDatabase() {
    abstract val ocupacionDao: OcupacionDao

    companion object{

        @Volatile
        private var INSTANCE: OcupacionDb? = null

        fun getInstance(context: Context): OcupacionDb {
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        OcupacionDb::class.java,
                        "Ocupaciones"
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