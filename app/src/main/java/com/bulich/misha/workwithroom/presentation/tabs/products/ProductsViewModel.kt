package com.bulich.misha.workwithroom.presentation.tabs.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bulich.misha.workwithroom.data.db.Products
import com.bulich.misha.workwithroom.data.db.ProductsRepositoryIMPL
import kotlinx.coroutines.launch

class ProductsViewModel(private val productsRepositoryIMPL: ProductsRepositoryIMPL) : ViewModel() {

    val products = productsRepositoryIMPL.products

    fun getFilter (nameCategory:String, priceProduct:String):
            LiveData<List<Products>> {
        return productsRepositoryIMPL.getFilter(nameCategory, priceProduct)
    }

    fun startInsert(nameProduct:String, categoryProduct:String, priceProduct:String) {
        insertProduct(Products(0,nameProduct, categoryProduct, priceProduct))
    }

    fun startUpdateProduct(idProduct:Int, nameProduct:String, nameCategory:String, priceProduct:String) {
        updateProduct(Products(idProduct, nameProduct, nameCategory, priceProduct))
    }

    fun insertProduct(products: Products) = viewModelScope.launch{

        productsRepositoryIMPL.insertProduct(products)
    }

    fun updateProduct(products: Products) = viewModelScope.launch{

        productsRepositoryIMPL.updateProduct(products)
    }

    fun deleteProduct(products: Products) = viewModelScope.launch{

        productsRepositoryIMPL.deleteProduct(products)
    }

    fun deleteAllProducts() = viewModelScope.launch{

        productsRepositoryIMPL.deleteAllProducts()
    }
}