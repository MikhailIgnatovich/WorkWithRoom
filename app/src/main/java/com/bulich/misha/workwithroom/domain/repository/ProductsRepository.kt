package com.bulich.misha.workwithroom.domain.repository

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.bulich.misha.workwithroom.data.db.Products

interface ProductsRepository {

    suspend fun insertProduct(products: Products)

    suspend fun updateProduct(products: Products)

    suspend fun deleteProduct(products: Products)

    suspend fun deleteAllProducts()

    fun getAllProducts(): LiveData<List<Products>>

    fun getFilter(nameCategory: String, priceProduct: String): LiveData<List<Products>>
}