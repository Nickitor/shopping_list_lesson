package com.nikitazamyslov.shoppinglist.domain.repository

import com.nikitazamyslov.shoppinglist.domain.entity.ShopItem

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItemById(id: Int)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItemById(id: Int): ShopItem

    fun getShopList(): List<ShopItem>
}