package com.bulich.misha.workwithroom.tabs.products

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.bulich.misha.workwithroom.R
import com.bulich.misha.workwithroom.databinding.PanelEditProductBinding
import com.bulich.misha.workwithroom.db.ProductsDatabase
import com.bulich.misha.workwithroom.db.ProductsRepository
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class PanelEditProduct : BottomSheetDialogFragment(), View.OnClickListener {

    private var binding: PanelEditProductBinding? = null
    private var productRepository: ProductsRepository? = null
    private var productsViewModel: ProductsViewModel? = null
    private var productsViewModelFactory: ProductsViewModelFactory? = null
    private var idProduct: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.panel_edit_product, container, false)

        idProduct = arguments?.getString("idProduct")?.toInt()
        binding?.editNameProduct?.setText(arguments?.getString("nameProduct"))
        binding?.editCategoryProduct?.setText(arguments?.getString("categoryProduct"))
        binding?.editPriceProduct?.setText(arguments?.getString("priceProduct"))

        val productDao =
            ProductsDatabase.getInstance((context as FragmentActivity).application).products()
        productRepository = ProductsRepository(productDao)
        productsViewModelFactory = ProductsViewModelFactory(productRepository!!)
        productsViewModel =
            ViewModelProvider(this, productsViewModelFactory!!).get(ProductsViewModel::class.java)

        binding?.buttonEditProduct?.setOnClickListener(this)



        return binding?.root
    }

    override fun onClick(v: View?) {
        productsViewModel?.startUpdateProduct(
            idProduct.toString().toInt(),
            binding?.resEditNameProduct?.text.toString(),
            binding?.resEditCategoryProduct?.text.toString(),
            binding?.resEditPriceProduct?.text.toString()
        )

        dismiss()

        (context as FragmentActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.content, CatalogProducts()).commit()
    }

}