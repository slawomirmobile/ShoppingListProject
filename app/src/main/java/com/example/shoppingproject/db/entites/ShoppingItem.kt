package com.example.shoppingproject.db.entites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingItem(

    @ColumnInfo(name = "item_name")
    var itemsName: String,
    @ColumnInfo(name = "item_amount")
    var itemsAmount: Int


) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}