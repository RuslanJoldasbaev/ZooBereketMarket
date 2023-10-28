package com.example.zoobereketmarket.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.zoobereketmarket.R
import com.example.zoobereketmarket.data.constants.Constants
import com.example.zoobereketmarket.data.models.categories.CategoriesItemData
import com.example.zoobereketmarket.databinding.ItemAnimalsBinding

class CategoriesAdapter : ListAdapter<CategoriesItemData, CategoriesAdapter.CategoriesViewHolder>(
    diffCallBack
) {

    inner class CategoriesViewHolder(private val binding: ItemAnimalsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val d = getItem(adapterPosition)

            binding.apply {
                itemAnimalsText.text = d.name
                Glide.with(itemAnimalsImg)
                    .load(d.splash)
                    .into(itemAnimalsImg)
                root.setOnClickListener {
                    onItemClick.invoke(d)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        return CategoriesViewHolder(
            ItemAnimalsBinding.bind(
                LayoutInflater.from(
                    parent.context
                ).inflate(R.layout.item_animals, parent, false)
            )
        )
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind()
    }

    private object diffCallBack : DiffUtil.ItemCallback<CategoriesItemData>() {
        override fun areItemsTheSame(
            oldItem: CategoriesItemData,
            newItem: CategoriesItemData
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CategoriesItemData,
            newItem: CategoriesItemData
        ): Boolean {
            return oldItem == newItem
        }
    }

    private lateinit var onItemClick: (CategoriesItemData) -> Unit
    fun setOnItemClickListener(a: (CategoriesItemData) -> Unit) {
        this.onItemClick = a
    }
}