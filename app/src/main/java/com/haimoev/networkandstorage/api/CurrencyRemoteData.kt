package com.haimoev.networkandstorage.api

data class CurrencyRemoteData(
    val base: String,
    val date: String,
    val rates: ConversionRates
)