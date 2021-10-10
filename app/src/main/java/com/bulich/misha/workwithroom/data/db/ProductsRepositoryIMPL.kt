package com.bulich.misha.workwithroom.data.db

import androidx.lifecycle.LiveData
import com.bulich.misha.workwithroom.domain.repository.ProductsRepository

class ProductsRepositoryIMPL(private val productsDao: ProductsDao) : ProductsRepository {

    override suspend fun insertProduct(products: Products) {
        TODO("Not yet implemented")
    }

    override suspend fun updateProduct(products: Products) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteProduct(products: Products) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllProducts() {
        TODO("Not yet implemented")
    }

    override fun getAllProducts(): LiveData<List<Products>> {
        TODO("Not yet implemented")
    }

    override fun getFilter(nameCategory: String, priceProduct: String): LiveData<List<Products>> {
        TODO("Not yet implemented")
    }


}