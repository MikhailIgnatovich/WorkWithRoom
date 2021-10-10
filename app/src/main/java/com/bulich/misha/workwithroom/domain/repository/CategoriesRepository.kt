package com.bulich.misha.workwithroom.domain.repository

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.bulich.misha.workwithroom.data.db.Categories

interface CategoriesRepository {

    suspend fun insertCategory(categories: Categories)

    suspend fun updateCategory(categories: Categories)

    suspend fun deleteCategory(categories: Categories)

    suspend fun deleteAllCategories()

    fun getAllCategories(): LiveData<List<Categories>>
}