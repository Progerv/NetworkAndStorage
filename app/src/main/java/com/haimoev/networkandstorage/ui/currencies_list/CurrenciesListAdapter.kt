package com.haimoev.networkandstorage.ui.currencies_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.haimoev.networkandstorage.R
import com.haimoev.networkandstorage.data.local.entities.CurrencyEntity
import kotlinx.android.synthetic.main.item_currency_list.view.*

interface OnItemClickCallback {
    fun onItemClick(string: String)
}

class CurrenciesListAdapter(private val onItemClickCallback: OnItemClickCallback) :
    RecyclerView.Adapter<CurrenciesListAdapter.CurrenciesListViewHolder>() {

    private val currenciesList: MutableList<CurrencyEntity> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrenciesListViewHolder {
        return CurrenciesListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_currency_list, parent, false))
    }

    override fun onBindViewHolder(
        holder: CurrenciesListViewHolder,
        position: Int
    ) {
        holder.bind(currenciesList[position], onItemClickCallback)
    }

    override fun getItemCount(): Int {
        return currenciesList.size
    }

    fun updateList(list: List<CurrencyEntity>) {
        this.currenciesList.clear()
        this.currenciesList.addAll(list)
        notifyDataSetChanged()
    }

    class CurrenciesListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: CurrencyEntity, onItemClickCallback: OnItemClickCallback) {

            itemView.currencyItemTextView.text = model.currencyName

            itemView.setOnClickListener {
                onItemClickCallback.onItemClick(
                    model.currencyName
                )
            }
        }
    }
}