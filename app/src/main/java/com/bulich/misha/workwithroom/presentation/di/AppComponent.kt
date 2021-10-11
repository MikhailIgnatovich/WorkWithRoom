package com.bulich.misha.workwithroom.presentation.di

import android.content.Context
import com.bulich.misha.workwithroom.presentation.tabs.CatalogClothes
import com.bulich.misha.workwithroom.presentation.tabs.Panel
import com.bulich.misha.workwithroom.presentation.tabs.categories.CatalogCategories
import com.bulich.misha.workwithroom.presentation.tabs.categories.PanelEditCategory
import com.bulich.misha.workwithroom.presentation.tabs.products.CatalogProducts
import com.bulich.misha.workwithroom.presentation.tabs.products.PanelEditProduct
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DatabaseModule::class])
interface AppComponent {

    fun inject(catalogCategories: CatalogCategories)
    fun inject(panelEditCategory: PanelEditCategory)
    fun inject(catalogProducts: CatalogProducts)
    fun inject(panelEditProduct: PanelEditProduct)
    fun inject(catalogClothes: CatalogClothes)
    fun inject(panel: Panel)

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}