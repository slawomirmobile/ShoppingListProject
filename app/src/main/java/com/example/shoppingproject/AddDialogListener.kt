package com.example.shoppingproject

import com.example.shoppingproject.db.entites.ShoppingItem

interface AddDialogListener {
    fun addButtonClicked(item: ShoppingItem)
}