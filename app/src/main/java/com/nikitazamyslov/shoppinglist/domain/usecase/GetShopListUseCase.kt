package com.nikitazamyslov.shoppinglist.domain.usecase

import com.nikitazamyslov.shoppinglist.domain.repository.ShopListRepository

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopList() = shopListRepository.getShopList()
}