package com.bulich.misha.workwithroom.data.db

import androidx.lifecycle.LiveData
import com.bulich.misha.workwithroom.domain.repository.CategoriesRepository
import javax.inject.Inject

class CategoriesRepositoryIMPL @Inject constructor(private val categoriesDao: CategoriesDao) :
    CategoriesRepository {

    override suspend fun insertCategory(categories: Categories) {
        categoriesDao.insertCategory(categories)
    }

    override suspend fun updateCategory(categories: Categories) {
        categoriesDao.updateCategory(categories)
    }

    override suspend fun deleteCategory(categories: Categories) {
        categoriesDao.deleteCategory(categories)
    }

    override suspend fun deleteAllCategories() {
        categoriesDao.deleteAllCategories()
    }

    override fun getAllCategories(): LiveData<List<Categories>> {
        return categoriesDao.getAllCategories()
    }


}