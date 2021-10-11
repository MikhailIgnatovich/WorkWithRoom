package com.bulich.misha.workwithroom.presentation.di

import com.bulich.misha.workwithroom.data.db.CategoriesRepositoryIMPL
import com.bulich.misha.workwithroom.data.db.ProductsRepositoryIMPL
import com.bulich.misha.workwithroom.domain.repository.CategoriesRepository
import com.bulich.misha.workwithroom.domain.repository.ProductsRepository
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideProductsRepositoryIMPLtoProductsRepository(productsRepositoryIMPL: ProductsRepositoryIMPL): ProductsRepository {
        return productsRepositoryIMPL
    }

    @Provides
    fun provideCategoriesRepositoryIMPLtoCategoriesRepository(categoriesRepositoryIMPL: CategoriesRepositoryIMPL): CategoriesRepository {
        return categoriesRepositoryIMPL
    }
}