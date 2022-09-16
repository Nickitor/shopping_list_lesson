package com.nikitazamyslov.shoppinglist.domain.usecase

import com.nikitazamyslov.shoppinglist.domain.entity.ShopItem
import com.nikitazamyslov.shoppinglist.domain.repository.ShopListRepository

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun addShopItem(shopItem: ShopItem) {
        shopListRepository.addShopItem(shopItem)
    }
}