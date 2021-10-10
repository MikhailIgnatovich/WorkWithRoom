package com.bulich.misha.workwithroom.presentation.tabs.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bulich.misha.workwithroom.data.db.CategoriesRepositoryIMPL

class CategoriesViewModelFactory(private val categoriesRepositoryIMPL: CategoriesRepositoryIMPL): ViewModelProvider.Factory{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CategoriesViewModel::class.java)) {
            return CategoriesViewModel(categoriesRepositoryIMPL) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }

}