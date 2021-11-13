package com.juanvargas.mercadolibreprueba.detailproduct.data.repository

import com.juanvargas.mercadolibreprueba.detailproduct.data.model.ResponseDescriptionProduct
import com.juanvargas.mercadolibreprueba.detailproduct.data.model.ResponseDetailProduct
import com.juanvargas.mercadolibreprueba.util.NetworkClient
import com.juanvargas.mercadolibreprueba.util.ServiceApi
import retrofit2.create

class DetailProductRepositoryImpl:DetailProductRepository {
    private val service = NetworkClient.buildRetrofitClient().create<ServiceApi>()

    override suspend fun getItem(productId: String): ArrayList<ResponseDetailProduct> {
        return service.getItem(productId)
    }

    override suspend fun getItemDescription(productId: String): ResponseDescriptionProduct {
        return service.getItemDescription(productId)
    }

}