package com.nikitazamyslov.shoppinglist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nikitazamyslov.shoppinglist.data.ShopListRepositoryImpl
import com.nikitazamyslov.shoppinglist.domain.entity.ShopItem
import com.nikitazamyslov.shoppinglist.domain.usecase.DeleteShopItemUseCase
import com.nikitazamyslov.shoppinglist.domain.usecase.EditShopItemUseCase
import com.nikitazamyslov.shoppinglist.domain.usecase.GetShopListUseCase

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    private val _shopList = getShopListUseCase.getShopList()
    val shopList: LiveData<List<ShopItem>>
        get() = _shopList

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun editShopItem(shopItem: ShopItem) {
        editShopItemUseCase.editShopItem(shopItem.copy(enabled = !shopItem.enabled))
    }
}