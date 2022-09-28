package com.nikitazamyslov.shoppinglist.presentation

import com.nikitazamyslov.shoppinglist.domain.entity.ShopItem

interface OnItemClickListener {

    fun onItemClicker(item: ShopItem)
}