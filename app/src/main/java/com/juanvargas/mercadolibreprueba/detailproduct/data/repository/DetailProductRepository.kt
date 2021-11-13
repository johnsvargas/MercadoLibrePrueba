package com.juanvargas.mercadolibreprueba.detailproduct.data.repository

import com.juanvargas.mercadolibreprueba.detailproduct.data.model.ResponseDescriptionProduct
import com.juanvargas.mercadolibreprueba.detailproduct.data.model.ResponseDetailProduct

interface DetailProductRepository {
    suspend fun getItem(productId: String):ArrayList<ResponseDetailProduct>

    suspend fun getItemDescription(productId: String): ResponseDescriptionProduct
}