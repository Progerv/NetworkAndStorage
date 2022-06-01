package com.haimoev.networkandstorage.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "conversion_rates")
data class CurrencyEntity(
    @PrimaryKey val currencyName: String,
    val currencyValue: Double
)