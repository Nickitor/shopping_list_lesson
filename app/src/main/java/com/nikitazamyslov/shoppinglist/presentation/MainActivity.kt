package com.nikitazamyslov.shoppinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.nikitazamyslov.shoppinglist.databinding.ActivityMainBinding
import com.nikitazamyslov.shoppinglist.presentation.adapter.ShopListAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var shopAdapter: ShopListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setupRecyclerView()

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this) {
            shopAdapter.dataset = it
        }

        setContentView(binding.root)
    }

    private fun setupRecyclerView() {
        shopAdapter = ShopListAdapter()
        var a = with(binding.activityMainRv) {
            adapter = shopAdapter
            binding.activityMainRv.recycledViewPool.setMaxRecycledViews(
                ShopListAdapter.VIEW_TYPE_ENABLED,
                ShopListAdapter.MAX_POOL_SIZE
            )
            recycledViewPool.setMaxRecycledViews(
                ShopListAdapter.VIEW_TYPE_DISABLED,
                ShopListAdapter.MAX_POOL_SIZE
            )
        }
        setSwipeListener()
        setupClickListener()
        setupLongClickListener()
    }

    private fun setSwipeListener() {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                viewModel.deleteShopItem(shopAdapter.dataset[viewHolder.adapterPosition])
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.activityMainRv)
    }

    private fun setupLongClickListener() {
        shopAdapter.onLongClickListener = {
            viewModel.editShopItem(it)
        }
    }

    private fun setupClickListener() {
        shopAdapter.onClickListener = {
            println(it.toString())
        }
    }
}