package com.nikitazamyslov.shoppinglist.domain.usecase

import com.nikitazamyslov.shoppinglist.domain.entity.ShopItem
import com.nikitazamyslov.shoppinglist.domain.repository.ShopListRepository

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun editShopItem(shopItem: ShopItem) {
        shopListRepository.editShopItem(shopItem)
    }
}