package com.bulich.misha.workwithroom.domain.useCase

import androidx.lifecycle.LiveData
import com.bulich.misha.workwithroom.data.db.Categories
import com.bulich.misha.workwithroom.domain.repository.CategoriesRepository
import javax.inject.Inject

class CategoriesUseCase @Inject constructor(private val categoriesRepository: CategoriesRepository) {

    suspend fun insertCategory(categories: Categories) {
        categoriesRepository.insertCategory(categories)
    }

    suspend fun updateCategory(categories: Categories) {
        categoriesRepository.updateCategory(categories)
    }

    suspend fun deleteCategory(categories: Categories) {
        categoriesRepository.deleteCategory(categories)
    }

    suspend fun deleteAllCategories() {
        categoriesRepository.deleteAllCategories()
    }

    fun getAllCategories(): LiveData<List<Categories>> {
        return categoriesRepository.getAllCategories()
    }
}