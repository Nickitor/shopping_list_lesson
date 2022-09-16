package com.nikitazamyslov.shoppinglist.domain.entity

data class ShopItem(
    val id: Int,
    val name: String,
    val count: Int,
    val enabled: Boolean,
)