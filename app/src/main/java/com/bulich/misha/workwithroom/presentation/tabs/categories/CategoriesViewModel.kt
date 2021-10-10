package com.bulich.misha.workwithroom.presentation.tabs.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bulich.misha.workwithroom.data.db.Categories
import com.bulich.misha.workwithroom.data.db.CategoriesRepositoryIMPL
import kotlinx.coroutines.launch

class CategoriesViewModel(private val categoriesRepositoryIMPL: CategoriesRepositoryIMPL) : ViewModel() {

    val categories = categoriesRepositoryIMPL.categories

    fun startInsert(nameCategories: String) {
        insert(Categories(0, nameCategories))
    }

    fun startUpdate(idCategories: Int, nameCategories: String) {
        updateCategory(Categories(idCategories, nameCategories))
    }

    fun insert(categories: Categories) = viewModelScope.launch {
        categoriesRepositoryIMPL.insertCategory(categories)
    }

    fun updateCategory(categories: Categories) = viewModelScope.launch {
        categoriesRepositoryIMPL.updateCategory(categories)
    }

    fun deleteCategories(categories: Categories) = viewModelScope.launch {
        categoriesRepositoryIMPL.deleteCategory(categories)
    }

    fun deleteAllCategories() = viewModelScope.launch {
        categoriesRepositoryIMPL.deleteAllCategories()
    }
}