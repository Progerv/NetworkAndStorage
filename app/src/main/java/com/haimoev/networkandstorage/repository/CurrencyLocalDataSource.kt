package com.haimoev.networkandstorage.repository

import androidx.lifecycle.LiveData
import com.haimoev.networkandstorage.data.local.database.CurrenciesDatabase
import com.haimoev.networkandstorage.data.local.entities.CurrencyEntity
import javax.inject.Inject

class CurrencyLocalDataSource @Inject constructor(private val database: CurrenciesDatabase) {

    val allCurrenciesList: LiveData<List<CurrencyEntity>> = database.currenciesListDao().currencyList()

    suspend fun insertCurrencyIntoDatabase(currency: CurrencyEntity) {
        return database.currenciesListDao().insertCurrency(currency)
    }
}