package com.nikitazamyslov.shoppinglist.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nikitazamyslov.shoppinglist.R
import com.nikitazamyslov.shoppinglist.domain.entity.ShopItem

class ShopListAdapter : ListAdapter<ShopItem, ViewHolder>(ShopItemDiffCallback()) {

    var onClickListener: ((ShopItem) -> Unit)? = null
    var onLongClickListener: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                when (viewType) {
                    VIEW_TYPE_ENABLED -> R.layout.item_shop_enabled
                    VIEW_TYPE_DISABLED -> R.layout.item_shop_disabled
                    else -> {
                        throw Exception("Invalid view type")
                    }
                }, parent, false
            )
        )
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).enabled) VIEW_TYPE_ENABLED else VIEW_TYPE_DISABLED
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            val data = getItem(position)
            bind(data)
            itemView.setOnLongClickListener {
                onLongClickListener?.invoke(data)
                true
            }
            itemView.setOnClickListener {
                onClickListener?.invoke(data)
            }
        }
    }

    companion object {
        const val VIEW_TYPE_DISABLED = 0
        const val VIEW_TYPE_ENABLED = 1
        const val MAX_POOL_SIZE = 15
    }
}