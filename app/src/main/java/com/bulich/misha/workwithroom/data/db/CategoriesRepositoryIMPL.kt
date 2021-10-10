package com.bulich.misha.workwithroom.data.db

import androidx.lifecycle.LiveData
import com.bulich.misha.workwithroom.domain.repository.CategoriesRepository

class CategoriesRepositoryIMPL(private val categoriesDao: CategoriesDao) : CategoriesRepository {

    override suspend fun insertCategory(categories: Categories) {
        TODO("Not yet implemented")
    }

    override suspend fun updateCategory(categories: Categories) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCategory(categories: Categories) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllCategories() {
        TODO("Not yet implemented")
    }

    override fun getAllCategories(): LiveData<List<Categories>> {
        TODO("Not yet implemented")
    }


}