package com.juanvargas.mercadolibreprueba.search.data.repository

import com.juanvargas.mercadolibreprueba.search.data.model.Response

interface SearchRepository {
    suspend fun searchItem(query: String):Response
}