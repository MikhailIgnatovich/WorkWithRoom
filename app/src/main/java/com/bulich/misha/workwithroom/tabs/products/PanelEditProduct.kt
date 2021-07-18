package com.bulich.misha.workwithroom.tabs.products

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bulich.misha.workwithroom.R
import com.bulich.misha.workwithroom.databinding.PanelEditProductBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class PanelEditProduct : BottomSheetDialogFragment() {

    private var binding: PanelEditProductBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.panel_edit_product, container, false)
        return binding?.root
    }
}