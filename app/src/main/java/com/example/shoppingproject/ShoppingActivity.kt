package com.example.shoppingproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppingproject.adapter.ShoppingAdapter
import com.example.shoppingproject.db.entites.ShoppingItem
import com.example.shoppingproject.viewmodel.ShoppingViewModel
import com.example.shoppingproject.viewmodel.ShoppingViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.shopping_row.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import org.kodein.di.android.kodein


class ShoppingActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory: ShoppingViewModelFactory by instance ()
    lateinit var viewModel: ShoppingViewModel




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProvider(this, factory).get(ShoppingViewModel::class.java)
        val adapter = ShoppingAdapter(listOf(), viewModel)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.getAllItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()

        })




        fabButton.setOnClickListener {
                    AddShoppingItemDialog(this, object : AddDialogListener {
                        override fun addButtonClicked(item: ShoppingItem) {
                            viewModel.upsert(item)



                        }

                    }).show()
        }
    }
}