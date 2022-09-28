package com.nikitazamyslov.shoppinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Adapter
import android.widget.ListAdapter
import androidx.lifecycle.ViewModelProvider
import com.nikitazamyslov.shoppinglist.R
import com.nikitazamyslov.shoppinglist.databinding.ActivityMainBinding
import com.nikitazamyslov.shoppinglist.domain.entity.ShopItem

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this) {
            binding.activityMainRv.adapter = ShopListAdapter(it, this)
        }

        setContentView(binding.root)
    }

    override fun onItemClicker(item: ShopItem) {
        viewModel.editShopItem(item)
    }
}