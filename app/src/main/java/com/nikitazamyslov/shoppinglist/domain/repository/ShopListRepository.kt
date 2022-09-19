package com.nikitazamyslov.shoppinglist.domain.repository

import androidx.lifecycle.LiveData
import com.nikitazamyslov.shoppinglist.domain.entity.ShopItem

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItemById(id: Int): ShopItem?

    fun getShopList(): LiveData<List<ShopItem>>
}