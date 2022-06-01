package com.haimoev.networkandstorage.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.haimoev.networkandstorage.Constants.DATABASE_NAME
import com.haimoev.networkandstorage.Constants.DATABASE_VERSION
import com.haimoev.networkandstorage.data.local.entities.CurrencyEntity

/**
 * Класс [CurrenciesDatabase] управляет базой данных Room внутри приложения
 */
@Database(entities = [CurrencyEntity::class], version = DATABASE_VERSION, exportSchema = false)
abstract class CurrenciesDatabase: RoomDatabase() {
    abstract fun currenciesListDao(): CurrenciesListDao

    companion object {
        /**
         * Функция для сборки базы данных
         */
        fun buildDatabase(context: Context): CurrenciesDatabase {
            return Room
                .databaseBuilder(context, CurrenciesDatabase::class.java, DATABASE_NAME)
                .build()
        }
    }
}