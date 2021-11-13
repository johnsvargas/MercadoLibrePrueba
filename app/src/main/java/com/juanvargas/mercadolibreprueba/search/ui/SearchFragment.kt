package com.juanvargas.mercadolibreprueba.search.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.juanvargas.mercadolibreprueba.R
import com.juanvargas.mercadolibreprueba.databinding.FragmentSeachBinding
import com.juanvargas.mercadolibreprueba.detailproduct.ui.DetailProductFragment
import com.juanvargas.mercadolibreprueba.search.viewmodel.SearchViewModel

class SearchFragment: Fragment() {
    private lateinit var binding : FragmentSeachBinding
    private val adapter by lazy { ProductAdapter() }
    private val viewModel by viewModels<SearchViewModel>()
    var queryToSearch:String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_seach,container,false)
        binding.lifecycleOwner = this

        viewModel.listProducts.observe(viewLifecycleOwner){stateApp->
            stateApp.fold({
                if(it.isNotEmpty()){
                    adapter.setData(it)
                }else{
                    if(adapter.itemCount ==0)
                        Toast.makeText(requireContext(),"No se encontraron resultados", Toast.LENGTH_SHORT).show()
                }
            },{ e,_->
                Toast.makeText(requireContext(),"Ocurrio un error: ${e.message}", Toast.LENGTH_SHORT).show()
            })
        }

        viewModel.isLanding.observe(viewLifecycleOwner){
            binding.pbSearch.isVisible = it
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView(){
        with(binding){
            adapter.setOnClickListener { product ->
                findNavController().navigate(R.id.action_searchFragment_to_detailProductFragment, bundleOf(
                    DetailProductFragment.DETAIL_PRODUCT to product
                ))
            }

            rvSearchItems.adapter = adapter
            tieSearch.setOnEditorActionListener { v, actionId, event ->
                return@setOnEditorActionListener when (actionId) {
                    EditorInfo.IME_ACTION_SEARCH -> {
                        queryToSearch = tieSearch.text.toString()
                        if(queryToSearch.isNotEmpty()){
                            viewModel.getProductList(queryToSearch)
                            adapter.clearListProducts()
                        }
                        true
                    }
                    else -> false
                }
            }
        }
    }

}