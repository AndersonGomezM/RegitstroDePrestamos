package edu.ucne.registrodeprestamos.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.ucne.registrodeprestamos.data.OcupacionDb
import edu.ucne.registrodeprestamos.data.PersonaDb
import javax.inject.Singleton

object AppModulePersona {
    @Module
    @InstallIn(SingletonComponent::class)
    object AppModulePersona {
        @Singleton
        @Provides
        fun providesDababase(@ApplicationContext context: Context): PersonaDb {
            return Room.databaseBuilder(
                context,
                PersonaDb::class.java,
                "Personas.db"
            ).fallbackToDestructiveMigration().build()
        }
    }
}