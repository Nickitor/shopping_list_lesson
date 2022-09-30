package com.nikitazamyslov.shoppinglist.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nikitazamyslov.shoppinglist.R
import com.nikitazamyslov.shoppinglist.domain.entity.ShopItem

class ShopListAdapter : RecyclerView.Adapter<ShopListAdapter.ViewHolder>() {

    var dataset = listOf<ShopItem>()
        set(value) {
            val callback = ShopListDiffCallback(dataset, value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    var onClickListener: ((ShopItem) -> Unit)? = null
    var onLongClickListener: ((ShopItem) -> Unit)? = null

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var name: TextView
        private var count: TextView

        init {
            view.apply {
                name = view.findViewById(R.id.item_shop_name)
                count = view.findViewById(R.id.item_shop_count)
            }
        }

        fun bind(data: ShopItem) {
            name.text = data.name
            count.text = data.count.toString()
            itemView.setOnLongClickListener {
                onLongClickListener?.invoke(data)
                true
            }
            itemView.setOnClickListener {
                onClickListener?.invoke(data)
            }
        }
    }

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
        return if (dataset[position].enabled) VIEW_TYPE_ENABLED else VIEW_TYPE_DISABLED
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount() = dataset.size

    companion object {
        const val VIEW_TYPE_DISABLED = 0
        const val VIEW_TYPE_ENABLED = 1
        const val MAX_POOL_SIZE = 15
    }
}