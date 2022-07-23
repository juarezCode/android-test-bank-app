package com.upax.testbankapp.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.upax.testbankapp.R
import com.upax.testbankapp.databinding.ItemCardBinding
import com.upax.testbankapp.models.Card

class CardsAdapter : ListAdapter<Card, CardsAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = getItem(position)

        with(holder.binding) {
            txtCardFullName.text = card.name
            txtCardNumber.text = card.card
            txtCardAmount.text = "$${card.balance}"
            txtCardStatus.text = card.status
            txtCardIsTitular.text = card.type

            if (card.status == "activa") {
                imgCardState.setImageResource(R.drawable.ic_card_active)
            } else {
                imgCardState.setImageResource(R.drawable.ic_card_inactive)
            }
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<Card>() {
        override fun areItemsTheSame(oldItem: Card, newItem: Card) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Card, newItem: Card) =
            oldItem == newItem
    }
}