package edu.ucne.registrodeprestamos.di

import android.content.Context
import androidx.room.Room
import edu.ucne.registrodeprestamos.data.OcupacionDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModuleOcupacion {
    @Singleton
    @Provides
    fun providesDababase(@ApplicationContext context: Context): OcupacionDb {
        return Room.databaseBuilder(
            context,
            OcupacionDb::class.java,
            "Ocupaciones.db"
        ).fallbackToDestructiveMigration().build()
    }
}