package com.example.shoppingproject.db.repository

import com.example.shoppingproject.db.ShoppingDatabase
import com.example.shoppingproject.db.entites.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    suspend fun upsert(item: ShoppingItem) = db.shoppingDao().upsert(item)
    suspend fun delete(item: ShoppingItem) = db.shoppingDao().delete(item)
    fun getAllItems() = db.shoppingDao().getAllItems()

}