package com.juanvargas.mercadolibreprueba.detailproduct.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.juanvargas.mercadolibreprueba.R
import com.juanvargas.mercadolibreprueba.databinding.FragmentDetailProductBinding
import com.juanvargas.mercadolibreprueba.detailproduct.viewmodel.DetailProductViewModel
import com.juanvargas.mercadolibreprueba.search.data.model.Product

class DetailProductFragment:Fragment() {
    private lateinit var binding : FragmentDetailProductBinding
    private val viewModel by viewModels<DetailProductViewModel>()

    private val adapter by lazy { AttributesAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_product,container,false)
        binding.lifecycleOwner = this
        arguments?.getParcelable<Product>(DETAIL_PRODUCT)?.let {
            binding.product = it
            viewModel.getProductDetail(it.id)
            viewModel.getDescription(it.id)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView(){

        viewModel.product.observe(viewLifecycleOwner){stateApp->
            stateApp.fold({
                binding.product = it
                adapter.setData(it.attributes)
            },{ e,_->
                Toast.makeText(requireContext(),"Ocurrio un error: ${e.message}", Toast.LENGTH_SHORT).show()
            })
        }

        viewModel.description.observe(viewLifecycleOwner){stateApp->
            stateApp.fold({
                binding.description = it
            },{ e,_->
                Toast.makeText(requireContext(),"Ocurrio un error: ${e.message}", Toast.LENGTH_SHORT).show()
            })
        }

        binding.rvAttributesDetailProduct.adapter = adapter

    }

    companion object{
        const val DETAIL_PRODUCT = "DETAIL_PRODUCT"
    }
}