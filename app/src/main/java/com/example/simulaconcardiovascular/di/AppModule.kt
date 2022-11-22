package com.example.simulaconcardiovascular.di

import android.content.Context
import androidx.room.Room
import com.example.simulaconcardiovascular.data.CardioDb
import com.example.simulaconcardiovascular.data.daos.ContactoDao
import com.example.simulaconcardiovascular.data.daos.EtapaDao
import com.example.simulaconcardiovascular.data.repositories.ContactoRepository
import com.example.simulaconcardiovascular.data.repositories.EtapaRepository
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
    fun provideCardioDb(@ApplicationContext context: Context): CardioDb {
        return Room.databaseBuilder(
            context,
            CardioDb::class.java,
            "CardioDb"
        )
            .fallbackToDestructiveMigration()
            .createFromAsset("CardioDb.db")
            .build()
    }

    @Provides
    fun ProvidesEtapaDAO(cardioDb: CardioDb): EtapaDao {
        return cardioDb.etapaDao
    }

    @Provides
    fun ProvidesEtapaRepository(etapaDao: EtapaDao): EtapaRepository {
        return EtapaRepository(etapaDao)
    }

    @Provides
    fun ProvidesContactoDAO(cardioDb: CardioDb): ContactoDao {
        return cardioDb.contactoDao
    }

    @Provides
    fun ProvidesContactoRepository(contactoDao: ContactoDao): ContactoRepository {
        return ContactoRepository(contactoDao)
    }

}