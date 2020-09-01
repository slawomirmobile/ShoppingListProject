package com.example.shoppingproject

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppingproject.db.entites.ShoppingItem
import kotlinx.android.synthetic.main.dialog_items_add.*

class AddShoppingItemDialog(context: Context, var addDialogListener: AddDialogListener):AppCompatDialog(context){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_items_add)

    tvAdd.setOnClickListener {
        val name = etName.text.toString()
        val amount = etAmount.text.toString().toInt()
        if (name.isEmpty()){
            Toast.makeText(context, "Uzupełnij pola", Toast.LENGTH_SHORT).show()
            return@setOnClickListener
        }

        val item = ShoppingItem(name, amount)
        addDialogListener.addButtonClicked(item)
        dismiss()


        tvCancel.setOnClickListener {
            cancel()
        }


    }



    }



}