package com.nikitazamyslov.shoppinglist.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nikitazamyslov.shoppinglist.R
import com.nikitazamyslov.shoppinglist.domain.entity.ShopItem

class ShopListAdapter(
    private val dataset: List<ShopItem>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<ShopListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var name: TextView
        private var count: TextView

        init {
            view.apply {
                name = view.findViewById(R.id.item_shop_name)
                count = view.findViewById(R.id.item_shop_count)
            }
        }

        fun bind(data: ShopItem, onItemClickListener: OnItemClickListener) {
            name.text = data.name
            count.text = data.count.toString()
            itemView.setOnLongClickListener {
                onItemClickListener.onItemClicker(data)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_shop_enabled, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataset[position], itemClickListener)
    }

    override fun getItemCount() = dataset.size
}