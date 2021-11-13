package com.juanvargas.mercadolibreprueba.detailproduct.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.juanvargas.mercadolibreprueba.databinding.ItemAttributeBinding
import com.juanvargas.mercadolibreprueba.search.data.model.AttributesML


class AttributesAdapter : RecyclerView.Adapter<AttributesAdapter.AttributesViewHolder>() {
    private val listAttributesML :MutableList<AttributesML> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttributesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = ItemAttributeBinding.inflate(layoutInflater, parent, false)
        return AttributesViewHolder(view)
    }

    override fun onBindViewHolder(holder: AttributesViewHolder, position: Int) {
        holder.bind(listAttributesML[position])
    }

    //Just 15 attributes
    override fun getItemCount() = listAttributesML.size

    fun setData(data : MutableList<AttributesML>) {
        val size = listAttributesML.size
        listAttributesML.addAll(data)
        val sizeNew = listAttributesML.size
        notifyItemRangeChanged(size, sizeNew)
    }


    inner class AttributesViewHolder(private val binding: ItemAttributeBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(attribute: AttributesML){

            with(binding){
                this.attribute = attribute
            }

        }

    }
}
