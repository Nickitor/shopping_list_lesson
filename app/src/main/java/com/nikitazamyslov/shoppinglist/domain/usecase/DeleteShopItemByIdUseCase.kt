package com.nikitazamyslov.shoppinglist.domain.usecase

import com.nikitazamyslov.shoppinglist.domain.entity.ShopItem
import com.nikitazamyslov.shoppinglist.domain.repository.ShopListRepository

class DeleteShopItemByIdUseCase(private val shopListRepository: ShopListRepository) {
    fun deleteShopItemById(shopItem: ShopItem) {
        shopListRepository.deleteShopItem(shopItem)
    }
}