package com.bulich.misha.workwithroom.presentation.tabs.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bulich.misha.workwithroom.data.db.Categories
import com.bulich.misha.workwithroom.data.db.CategoriesRepositoryIMPL
import com.bulich.misha.workwithroom.domain.useCase.CategoriesUseCase
import kotlinx.coroutines.launch

class CategoriesViewModel(private val categoriesUseCase: CategoriesUseCase) : ViewModel() {

    val categories = categoriesUseCase.getAllCategories()

    fun startInsert(nameCategories: String) {
        insert(Categories(0, nameCategories))
    }

    fun startUpdate(idCategories: Int, nameCategories: String) {
        updateCategory(Categories(idCategories, nameCategories))
    }

    fun insert(categories: Categories) = viewModelScope.launch {
        categoriesUseCase.insertCategory(categories)
    }

    private fun updateCategory(categories: Categories) = viewModelScope.launch {
        categoriesUseCase.updateCategory(categories)
    }

    fun deleteCategories(categories: Categories) = viewModelScope.launch {
        categoriesUseCase.deleteCategory(categories)
    }

    fun deleteAllCategories() = viewModelScope.launch {
        categoriesUseCase.deleteAllCategories()
    }
}