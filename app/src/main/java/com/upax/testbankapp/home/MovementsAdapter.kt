package com.upax.testbankapp.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.upax.testbankapp.R
import com.upax.testbankapp.databinding.ItemMovementBinding
import com.upax.testbankapp.models.Movement

class MovementsAdapter : ListAdapter<Movement, MovementsAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(val binding: ItemMovementBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemMovementBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movement = getItem(position)

        with(holder.binding) {
            txtMovementDate.text = movement.date
            txtMovementAmount.text = "$${movement.amount}"
            txtMovementTitle.text = movement.description

            if (movement.type == "abono") {
                txtMovementAmount.setTextColor(
                    ContextCompat.getColor(
                        root.context,
                        R.color.text_color
                    )
                )
            } else {
                txtMovementAmount.setTextColor(
                    ContextCompat.getColor(
                        root.context,
                        R.color.red
                    )
                )
            }
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<Movement>() {
        override fun areItemsTheSame(oldItem: Movement, newItem: Movement) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Movement, newItem: Movement) =
            oldItem == newItem
    }
}