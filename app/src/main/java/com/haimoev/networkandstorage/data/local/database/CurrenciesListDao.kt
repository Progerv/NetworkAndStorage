package com.haimoev.networkandstorage.data.local.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.haimoev.networkandstorage.data.local.entities.CurrencyEntity

@Dao
interface CurrenciesListDao {

    @Query("SELECT * FROM conversion_rates")
    fun currencyList(): LiveData<List<CurrencyEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrency(item: CurrencyEntity)
}