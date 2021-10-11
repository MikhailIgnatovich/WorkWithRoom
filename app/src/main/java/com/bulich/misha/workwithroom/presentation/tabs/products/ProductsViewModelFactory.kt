package com.bulich.misha.workwithroom.presentation.tabs.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bulich.misha.workwithroom.data.db.ProductsRepositoryIMPL
import com.bulich.misha.workwithroom.domain.useCase.ProductsUseCase
import javax.inject.Inject

class ProductsViewModelFactory @Inject constructor(private val productsUseCase: ProductsUseCase) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductsViewModel::class.java)) {
            return ProductsViewModel(productsUseCase) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }
}