package edu.ucne.registrodeprestamos.di

import android.content.Context
import androidx.room.Room
import edu.ucne.registrodeprestamos.data.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesDababase(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "SpellingDb"
        ).fallbackToDestructiveMigration().build()
    }
}