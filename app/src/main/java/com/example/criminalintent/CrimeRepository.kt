package com.example.criminalintent

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.criminalintent.database.CrimeDataBase
import java.util.UUID

private const val DATABASE_NAME = "crime-database"

class CrimeRepository private constructor(context: Context) {

    private val dataBase: CrimeDataBase = Room.databaseBuilder(
        context.applicationContext, // Контекст
        CrimeDataBase::class.java, // Класс БД
        DATABASE_NAME // имя файла БД, которую создаст Room
    ).build()

    private val crimeDao = dataBase.crimeDao()

    fun getCrimes(): LiveData<List<Crime>> = crimeDao.getCrimes()

    fun getCrime(uuid: UUID): LiveData<Crime?> = crimeDao.getCrime(uuid)

    companion object {
        private var INSTANCE: CrimeRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = CrimeRepository(context)
            }
        }

        fun get(): CrimeRepository {
            return INSTANCE ?: throw IllegalStateException("CrimeRepository must be initialized")
        }
    }
}

