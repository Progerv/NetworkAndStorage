package com.haimoev.networkandstorage.ui.currencies_list

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class CurrencyItemTouchCallback(
    private val adapter: CurrencyListAdapter
) : ItemTouchHelper.Callback() {

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int = makeMovementFlags(
        ItemTouchHelper.UP or ItemTouchHelper.DOWN,
        ItemTouchHelper.RIGHT
    )

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        adapter.swap(viewHolder.adapterPosition, target.adapterPosition)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        adapter.remove(viewHolder.adapterPosition)
    }
}
