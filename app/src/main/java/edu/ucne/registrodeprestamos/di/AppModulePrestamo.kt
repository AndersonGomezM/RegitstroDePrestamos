package edu.ucne.registrodeprestamos.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.ucne.registrodeprestamos.data.PrestamoDb
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModulePrestamo {
    @Singleton
    @Provides
    fun providesDababase(@ApplicationContext context: Context): PrestamoDb {
        return Room.databaseBuilder(
            context,
            PrestamoDb::class.java,
            "Prestamos.db"
        ).fallbackToDestructiveMigration().build()
    }
}