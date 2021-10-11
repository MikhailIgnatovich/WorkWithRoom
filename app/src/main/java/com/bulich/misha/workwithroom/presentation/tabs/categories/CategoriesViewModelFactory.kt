package com.bulich.misha.workwithroom.presentation.tabs.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bulich.misha.workwithroom.data.db.CategoriesRepositoryIMPL
import com.bulich.misha.workwithroom.domain.useCase.CategoriesUseCase
import javax.inject.Inject

class CategoriesViewModelFactory @Inject constructor(private val categoriesUseCase: CategoriesUseCase) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CategoriesViewModel::class.java)) {
            return CategoriesViewModel(categoriesUseCase) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }

}