package com.haimoev.networkandstorage.repository

import androidx.lifecycle.LiveData
import com.haimoev.networkandstorage.Constants
import com.haimoev.networkandstorage.data.local.entities.CurrencyEntity
import javax.inject.Inject
import com.haimoev.networkandstorage.api.Result
import com.haimoev.networkandstorage.api.successed

class CurrencyListRepository @Inject constructor(
    private val currencyListRemoteDataSource: CurrencyListRemoteDataSource,
    private val currencyLocalDataSource: CurrencyLocalDataSource
) {
    suspend fun currencyListUpdate(): String {

        when (val result =
            currencyListRemoteDataSource.currencyList()) {
            is Result.Success -> {
                if (result.successed) {
                    result.data.let { listCurr ->

                        val anyCurrency = listCurr.rates

                        currencyLocalDataSource.insertCurrencyIntoDatabase(
                            CurrencyEntity(
                                currencyName = "RUB",
                                currencyValue = anyCurrency.RUB
                            )
                        )

                        currencyLocalDataSource.insertCurrencyIntoDatabase(
                            CurrencyEntity(
                                currencyName = "EUR",
                                currencyValue = anyCurrency.EUR
                            )
                        )

                        currencyLocalDataSource.insertCurrencyIntoDatabase(
                            CurrencyEntity(
                                currencyName = "USD",
                                currencyValue = anyCurrency.USD
                            )
                        )

                        Result.Success(true)
                        return result.toString()
                    }
                } else {
                    Result.Error(Constants.GENERIC_ERROR)
                    return "Ошибка"
                }
            }
            else -> {
                result as Result.Error
                return ""
            }
        }
    }

    val allCurrenciesList: LiveData<List<CurrencyEntity>> = currencyLocalDataSource.allCurrenciesList
}