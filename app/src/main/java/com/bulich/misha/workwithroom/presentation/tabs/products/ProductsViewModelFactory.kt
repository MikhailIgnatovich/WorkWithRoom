package com.bulich.misha.workwithroom.presentation.tabs.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bulich.misha.workwithroom.data.db.ProductsRepositoryIMPL

class ProductsViewModelFactory(private val productsRepositoryIMPL: ProductsRepositoryIMPL): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductsViewModel::class.java)) {
            return ProductsViewModel(productsRepositoryIMPL) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }
}