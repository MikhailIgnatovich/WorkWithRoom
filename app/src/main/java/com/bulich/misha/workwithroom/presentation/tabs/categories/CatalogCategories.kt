package com.bulich.misha.workwithroom.presentation.tabs.categories

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bulich.misha.workwithroom.R
import com.bulich.misha.workwithroom.databinding.CatalogCategoriesBinding
import com.bulich.misha.workwithroom.data.db.Categories
import com.bulich.misha.workwithroom.data.db.CategoriesRepositoryIMPL
import com.bulich.misha.workwithroom.data.db.ProductsDatabase
import com.bulich.misha.workwithroom.presentation.MyApp
import com.bulich.misha.workwithroom.presentation.appComponent
import javax.inject.Inject

class CatalogCategories : Fragment(), View.OnClickListener {

    private var binding: CatalogCategoriesBinding? = null
    private val categoriesViewModel: CategoriesViewModel by lazy {
        ViewModelProvider(this, categoriesViewModelFactory)[CategoriesViewModel::class.java]
    }
    @Inject
    lateinit var categoriesViewModelFactory: CategoriesViewModelFactory
    private var categoriesAdapter: CategoriesAdapter? = null

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.catalog_categories, container, false)

        initRecyclerCategories()

        binding?.deleteAllCategories?.setOnClickListener(this)

        return binding?.root
    }

    private fun initRecyclerCategories() {
        binding?.recyclerCategories?.layoutManager = LinearLayoutManager(context)
        categoriesAdapter =
            CategoriesAdapter({ categories: Categories -> deleteCategory(categories) },
                { categories: Categories ->
                    editCategory(categories)
                })
        binding?.recyclerCategories?.adapter = categoriesAdapter

        displayList()
    }

    private fun editCategory(categories: Categories) {
        val panelCategories = PanelEditCategory()
        val parameters = Bundle()
        parameters.putString("idCategory", categories.id.toString())
        parameters.putString("nameCategory", categories.name)
        panelCategories.apply {
            arguments = parameters
        }

        panelCategories.show((context as FragmentActivity).supportFragmentManager, "editCategory")
    }

    private fun deleteCategory(categories: Categories) {
        categoriesViewModel.deleteCategories(categories)
    }

    private fun displayList() {
        categoriesViewModel.categories.observe(viewLifecycleOwner, Observer {
            categoriesAdapter?.setList(it)
            categoriesAdapter?.notifyDataSetChanged()
        })
    }

    override fun onClick(v: View?) {
        categoriesViewModel.deleteAllCategories()
    }
}