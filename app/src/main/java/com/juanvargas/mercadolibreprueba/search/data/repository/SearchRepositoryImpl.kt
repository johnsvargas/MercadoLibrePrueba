package com.juanvargas.mercadolibreprueba.search.data.repository

import com.juanvargas.mercadolibreprueba.search.data.model.Response
import com.juanvargas.mercadolibreprueba.util.NetworkClient
import com.juanvargas.mercadolibreprueba.util.ServiceApi
import retrofit2.create

class SearchRepositoryImpl:SearchRepository {
    private val service = NetworkClient.buildRetrofitClient().create<ServiceApi>()

    override suspend fun searchItem(query: String): Response {
        return service.searchItem(query)
    }
}