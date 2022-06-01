package com.haimoev.networkandstorage.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.haimoev.networkandstorage.R
import com.haimoev.networkandstorage.databinding.ActivityMainBinding
import com.haimoev.networkandstorage.ui.currencies_list.CurrencyItemTouchCallback
import com.haimoev.networkandstorage.ui.currencies_list.CurrencyListAdapter
import com.haimoev.networkandstorage.util.doOnChange
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::bind)
    private var currencyListAdapter = CurrencyListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        initLoadCurrency()

        val adapter = currencyListAdapter
        adapter.submitList(listOf())
        binding.currenciesRecyclerView.adapter = adapter
        ItemTouchHelper(CurrencyItemTouchCallback(adapter))
            .attachToRecyclerView(binding.currenciesRecyclerView)
    }

    override fun onResume() {
        super.onResume()

        initializeViews()
        observeViewModel()
    }

    private fun initLoadCurrency() {
        viewModel.loadCurrencyFromApi()
    }

    private fun initializeViews() {
        binding.currenciesRecyclerView.apply {
            binding.currenciesRecyclerView.layoutManager = LinearLayoutManager(context)
            adapter = currencyListAdapter
        }
    }

    private fun observeViewModel() {

        viewModel.allCurrenciesList.doOnChange(this) {
            val adapter = currencyListAdapter
            adapter.submitList(it)
            binding.currenciesRecyclerView.adapter = adapter
        }
    }
}