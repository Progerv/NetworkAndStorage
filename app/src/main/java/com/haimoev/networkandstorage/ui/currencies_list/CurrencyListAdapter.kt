package com.haimoev.networkandstorage.ui.currencies_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.haimoev.networkandstorage.R
import com.haimoev.networkandstorage.data.local.entities.CurrencyEntity
import com.haimoev.networkandstorage.util.format
import kotlinx.android.synthetic.main.item_currency_list.view.*
import java.util.*


class CurrencyListAdapter : ListAdapter<CurrencyEntity, CurrencyListAdapter.CurrencyListViewHolder>(callback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyListViewHolder {
        return CurrencyListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_currency_list, parent, false))
    }

    class CurrencyListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: CurrencyEntity) {

            itemView.currencyItemTextView.text = model.currencyName
            itemView.valueItemTextView.text = model.currencyValue.format(4)
            itemView.setOnClickListener {
                model.currencyName
            }
        }
    }

    fun swap(fromPosition: Int, toPosition: Int) {
        val current = currentList.toMutableList()
        Collections.swap(current, fromPosition, toPosition)
        submitList(current)
    }

    fun remove(position: Int) {
        val current = currentList.toMutableList()
        current.removeAt(position)
        submitList(current)
    }

    override fun onBindViewHolder(holder: CurrencyListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private companion object {

        private val callback: DiffUtil.ItemCallback<CurrencyEntity> = object : DiffUtil.ItemCallback<CurrencyEntity>() {

            override fun areItemsTheSame(oldItem: CurrencyEntity, newItem: CurrencyEntity): Boolean =
                oldItem.currencyName == newItem.currencyName

            override fun areContentsTheSame(oldItem: CurrencyEntity, newItem: CurrencyEntity): Boolean =
                oldItem == newItem

        }
    }
}