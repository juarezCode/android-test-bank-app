package com.upax.testbankapp.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.upax.testbankapp.databinding.ItemBalanceBinding
import com.upax.testbankapp.models.Balance

class BalancesAdapter : ListAdapter<Balance, BalancesAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(val binding: ItemBalanceBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBalanceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.root.layoutParams = ViewGroup.LayoutParams(
            (parent.measuredWidth * 0.7).toInt(),
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val balance = getItem(position)

        with(holder.binding) {
            txtBalanceTitle.text = "Saldo en cuenta: ${balance.account}"
            txtBalanceAmount.text = "$${balance.amount}"
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<Balance>() {
        override fun areItemsTheSame(oldItem: Balance, newItem: Balance) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Balance, newItem: Balance) =
            oldItem == newItem
    }
}