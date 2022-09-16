package com.nikitazamyslov.shoppinglist.domain.usecase

import com.nikitazamyslov.shoppinglist.domain.repository.ShopListRepository

class GetShopItemByIdUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopItemById(id: Int) = shopListRepository.getShopItemById(id)
}