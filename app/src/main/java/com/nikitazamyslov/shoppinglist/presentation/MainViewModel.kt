package com.nikitazamyslov.shoppinglist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nikitazamyslov.shoppinglist.data.ShopListRepositoryImpl
import com.nikitazamyslov.shoppinglist.domain.entity.ShopItem
import com.nikitazamyslov.shoppinglist.domain.usecase.DeleteShopItemByIdUseCase
import com.nikitazamyslov.shoppinglist.domain.usecase.EditShopItemUseCase
import com.nikitazamyslov.shoppinglist.domain.usecase.GetShopListUseCase

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopList = GetShopListUseCase(repository)
    private val deleteShopItemByIdUseCase = DeleteShopItemByIdUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    private val _shopList = MutableLiveData<List<ShopItem>>()
    val shopItem: LiveData<List<ShopItem>>
        get() = _shopList

    fun getShopList() {
        _shopList.value = getShopList.getShopList()
    }

    fun deleteShopItemById(id: Int) {
        deleteShopItemByIdUseCase.deleteShopItemById(id)
        getShopList()
    }

    fun editShopItem(shopItem: ShopItem) {
        editShopItemUseCase.editShopItem(shopItem.copy(enabled = !shopItem.enabled))
        getShopList()
    }
}