package com.example.shoppingproject.viewmodel

import androidx.lifecycle.ViewModel
import com.example.shoppingproject.db.entites.ShoppingItem
import com.example.shoppingproject.db.repository.ShoppingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private var repository: ShoppingRepository
): ViewModel() {

    fun upsert(item: ShoppingItem) = GlobalScope.launch(Dispatchers.IO) {
        repository.upsert(item)
    }

    fun delete(item:ShoppingItem) = GlobalScope.launch(Dispatchers.IO) {
        repository.delete(item)
    }

    fun getAllItems() = repository.getAllItems()
}