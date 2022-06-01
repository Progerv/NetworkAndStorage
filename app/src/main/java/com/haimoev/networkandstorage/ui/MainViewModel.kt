package com.haimoev.networkandstorage.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haimoev.networkandstorage.data.local.entities.CurrencyEntity
import com.haimoev.networkandstorage.repository.CurrencyListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repositoryCurrency: CurrencyListRepository
): ViewModel() {

    val allCurrenciesList: LiveData<List<CurrencyEntity>> = repositoryCurrency.allCurrenciesList

    fun loadCurrencyFromApi() {
        viewModelScope.launch(Dispatchers.IO) {
            repositoryCurrency.currencyListUpdate()
        }
    }
}