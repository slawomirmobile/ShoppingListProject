package com.example.shoppingproject.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoppingproject.db.entites.ShoppingItem

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item : ShoppingItem)
    @Delete
    suspend fun delete(item: ShoppingItem)
    @Query("SELECT * FROM shopping_items")
    fun getAllItems(): LiveData<List<ShoppingItem>>
}