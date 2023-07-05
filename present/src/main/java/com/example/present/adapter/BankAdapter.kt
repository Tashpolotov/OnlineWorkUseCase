package com.example.present.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineworkusecase.domain.model.BankTransactionModel
import com.example.present.databinding.ItemBinding

class BankAdapter:ListAdapter<BankTransactionModel, BankAdapter.BankViewHolder>(BankDiffutil()) {
    inner class BankViewHolder(private val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(model: BankTransactionModel) {
            binding.tvDate.text = model.date
            binding.textCurrency.text = model.valut
            binding.tvAmount.text = model.amount.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankViewHolder {
        return BankViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: BankViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class BankDiffutil: DiffUtil.ItemCallback<BankTransactionModel>() {
    override fun areItemsTheSame(
        oldItem: BankTransactionModel,
        newItem: BankTransactionModel,
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: BankTransactionModel,
        newItem: BankTransactionModel,
    ): Boolean {
        return oldItem == newItem
    }

}
