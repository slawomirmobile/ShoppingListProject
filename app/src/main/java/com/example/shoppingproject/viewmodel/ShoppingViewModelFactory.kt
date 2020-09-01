package com.example.shoppingproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppingproject.db.repository.ShoppingRepository


@Suppress("UNCHECKED_CAST")
class ShoppingViewModelFactory (
    private val shoppingRepository: ShoppingRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(shoppingRepository) as T
    }
}