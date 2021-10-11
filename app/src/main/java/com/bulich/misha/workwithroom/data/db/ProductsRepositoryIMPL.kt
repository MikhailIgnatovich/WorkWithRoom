package com.bulich.misha.workwithroom.data.db

import androidx.lifecycle.LiveData
import com.bulich.misha.workwithroom.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryIMPL @Inject constructor(private val productsDao: ProductsDao) : ProductsRepository {

    override suspend fun insertProduct(products: Products) {
        productsDao.insertProduct(products)
    }

    override suspend fun updateProduct(products: Products) {
        productsDao.updateProduct(products)
    }

    override suspend fun deleteProduct(products: Products) {
        productsDao.deleteProduct(products)
    }

    override suspend fun deleteAllProducts() {
        productsDao.deleteAllProducts()
    }

    override fun getAllProducts(): LiveData<List<Products>> {
        return productsDao.getAllProducts()
    }

    override fun getFilter(nameCategory: String, priceProduct: String): LiveData<List<Products>> {
        return productsDao.getFilter(nameCategory, priceProduct)
    }


}