package com.bulich.misha.workwithroom.presentation.tabs

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.bulich.misha.workwithroom.R
import com.bulich.misha.workwithroom.databinding.PanelBinding
import com.bulich.misha.workwithroom.data.db.CategoriesRepositoryIMPL
import com.bulich.misha.workwithroom.data.db.ProductsDatabase
import com.bulich.misha.workwithroom.data.db.ProductsRepositoryIMPL
import com.bulich.misha.workwithroom.presentation.appComponent
import com.bulich.misha.workwithroom.presentation.tabs.categories.CategoriesViewModel
import com.bulich.misha.workwithroom.presentation.tabs.categories.CategoriesViewModelFactory
import com.bulich.misha.workwithroom.presentation.tabs.products.ProductsViewModel
import com.bulich.misha.workwithroom.presentation.tabs.products.ProductsViewModelFactory
import javax.inject.Inject


class Panel : Fragment(), View.OnKeyListener, View.OnClickListener {

    private var binding: PanelBinding? = null

    @Inject
    lateinit var categoriesViewModelFactory: CategoriesViewModelFactory
    private val categoriesViewModel: CategoriesViewModel by lazy {
        ViewModelProvider(this, categoriesViewModelFactory)[CategoriesViewModel::class.java]
    }

    @Inject
    lateinit var productsViewModelFactory: ProductsViewModelFactory
    private val productsViewModel: ProductsViewModel by lazy {
        ViewModelProvider(this, productsViewModelFactory)[ProductsViewModel::class.java]
    }

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.panel, container, false)

        binding?.enterCategoryProduct?.setOnKeyListener(this)
        binding?.enterNameProduct?.setOnKeyListener(this)
        binding?.enterPriceProduct?.setOnKeyListener(this)

        binding?.buttonAddCategoryClothes?.setOnClickListener(this)
        binding?.buttonAddCategoryShoes?.setOnClickListener(this)
        binding?.buttonAddCategoryAccessories?.setOnClickListener(this)
        binding?.buttonAddProduct?.setOnClickListener(this)

        return binding?.root
    }

    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
        when (v.id) {

            R.id.enterNameProduct -> {
                if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    binding?.resEnterNameProduct?.text = binding?.enterNameProduct?.text
                    binding?.enterNameProduct?.setText("")
                    return true
                }
            }

            R.id.enterCategoryProduct -> {
                if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    binding?.resEnterCategoryProduct?.text = binding?.enterCategoryProduct?.text
                    binding?.enterCategoryProduct?.setText("")
                    return true
                }
            }

            R.id.enterPriceProduct -> {
                if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    binding?.resEnterPriceProduct?.text = binding?.enterPriceProduct?.text
                    binding?.enterPriceProduct?.setText("")
                    return true
                }
            }
        }
        return false
    }

    override fun onClick(v: View) {
        when (v.id) {

            R.id.buttonAddCategoryClothes -> {
                categoriesViewModel.startInsert(binding?.buttonAddCategoryClothes?.text?.toString()!!)
            }

            R.id.buttonAddCategoryShoes -> {
                categoriesViewModel.startInsert(binding?.buttonAddCategoryShoes?.text?.toString()!!)
            }

            R.id.buttonAddCategoryAccessories -> {
                categoriesViewModel.startInsert(binding?.buttonAddCategoryAccessories?.text?.toString()!!)
            }

            R.id.buttonAddProduct -> {
                productsViewModel.startInsert(
                    binding?.resEnterNameProduct?.text?.toString()!!,
                    binding?.resEnterCategoryProduct?.text?.toString()!!,
                    binding?.resEnterPriceProduct?.text?.toString()!!
                )

                clearResEnterProduct()
            }
        }
    }

    private fun clearResEnterProduct() {
        binding?.resEnterNameProduct?.setText("")
        binding?.resEnterCategoryProduct?.setText("")
        binding?.resEnterPriceProduct?.setText("")
    }
}