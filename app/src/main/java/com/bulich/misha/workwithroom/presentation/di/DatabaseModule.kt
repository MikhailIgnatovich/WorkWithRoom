package com.bulich.misha.workwithroom.presentation.di

import android.content.Context
import com.bulich.misha.workwithroom.data.db.CategoriesDao
import com.bulich.misha.workwithroom.data.db.ProductsDao
import com.bulich.misha.workwithroom.data.db.ProductsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideGetCategoriesDao(productsDatabase: ProductsDatabase): CategoriesDao {
        return productsDatabase.categoriesDao()
    }

    @Singleton
    @Provides
    fun provideGetProductsDao(productsDatabase: ProductsDatabase): ProductsDao {
        return productsDatabase.products()
    }

    @Singleton
    @Provides
    fun provideGetProductsDatabase(context: Context): ProductsDatabase {
        return ProductsDatabase.getInstance(context)
    }
}