package com.haimoev.networkandstorage.api

import com.haimoev.networkandstorage.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/latest?apikey=$API_KEY")
    suspend fun currencyList(): Response<CurrencyRemoteData>
}