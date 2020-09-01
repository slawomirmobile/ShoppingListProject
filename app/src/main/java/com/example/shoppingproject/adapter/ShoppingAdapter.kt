package com.example.shoppingproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingproject.R
import com.example.shoppingproject.db.entites.ShoppingItem
import com.example.shoppingproject.viewmodel.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_row.view.*


class ShoppingAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
): RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_row, parent, false)
            return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentShoppingItems = items[position]


        holder.itemView.nametxt.text = currentShoppingItems.itemsName
        holder.itemView.amount_txt.text = currentShoppingItems.itemsAmount.toString()


        //Delete button
        holder.itemView.delete_items.setOnClickListener {
            viewModel.delete(currentShoppingItems)
        }

        //Add button

        holder.itemView.add_items.setOnClickListener {
            currentShoppingItems.itemsAmount++
            viewModel.upsert(currentShoppingItems)
        }

        //Minus items

        holder.itemView.remove_amount_items.setOnClickListener {
            if (currentShoppingItems.itemsAmount > 0) {
                currentShoppingItems.itemsAmount--
                viewModel.upsert(currentShoppingItems)
            }



        }




    }

    inner class ShoppingViewHolder(itemview: View): RecyclerView.ViewHolder(itemview)
}