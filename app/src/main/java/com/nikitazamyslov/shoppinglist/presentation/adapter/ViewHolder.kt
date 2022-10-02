package com.nikitazamyslov.shoppinglist.presentation.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nikitazamyslov.shoppinglist.R
import com.nikitazamyslov.shoppinglist.domain.entity.ShopItem

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var name: TextView = view.findViewById(R.id.item_shop_name)
    private var count: TextView = view.findViewById(R.id.item_shop_count)

    fun bind(data: ShopItem) {
        name.text = data.name
        count.text = data.count.toString()
    }
}