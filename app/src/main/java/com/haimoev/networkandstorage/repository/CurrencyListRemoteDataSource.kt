package com.haimoev.networkandstorage.repository

import com.haimoev.networkandstorage.api.ApiInterface
import com.haimoev.networkandstorage.api.BaseRemoteDataSource
import com.haimoev.networkandstorage.api.CurrencyRemoteData
import javax.inject.Inject
import com.haimoev.networkandstorage.api.Result

class CurrencyListRemoteDataSource @Inject constructor(private val service: ApiInterface) :
    BaseRemoteDataSource() {

    suspend fun currencyList(): Result<CurrencyRemoteData> =
        getResult {
            service.currencyList()
        }
}