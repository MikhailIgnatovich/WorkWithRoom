package com.bulich.misha.workwithroom.domain.useCase

import androidx.lifecycle.LiveData
import com.bulich.misha.workwithroom.data.db.Products
import com.bulich.misha.workwithroom.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductsUseCase @Inject constructor(private val productsRepository: ProductsRepository) {

    suspend fun insertProduct(products: Products){
        productsRepository.insertProduct(products)
    }

    suspend fun updateProduct(products: Products){
        productsRepository.updateProduct(products)
    }

    suspend fun deleteProduct(products: Products){
        productsRepository.deleteProduct(products)
    }

    suspend fun deleteAllProducts(){
        productsRepository.deleteAllProducts()
    }

    fun getAllProducts(): LiveData<List<Products>> {
        return productsRepository.getAllProducts()
    }

    fun getFilter(nameCategory: String, priceProduct: String): LiveData<List<Products>> {
        return productsRepository.getFilter(nameCategory, priceProduct)
    }
}