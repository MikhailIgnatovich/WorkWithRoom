package com.bulich.misha.workwithroom.tabs.products

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bulich.misha.workwithroom.R
import com.bulich.misha.workwithroom.databinding.CatalogProductsBinding


class CatalogProducts : Fragment() {

    private var binding: CatalogProductsBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.catalog_products, container, false)
        return binding?.root
    }
}