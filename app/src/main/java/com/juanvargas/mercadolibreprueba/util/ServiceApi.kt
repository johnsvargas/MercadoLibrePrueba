package com.juanvargas.mercadolibreprueba.util

import com.juanvargas.mercadolibreprueba.detailproduct.data.model.ResponseDescriptionProduct
import com.juanvargas.mercadolibreprueba.detailproduct.data.model.ResponseDetailProduct
import com.juanvargas.mercadolibreprueba.search.data.model.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceApi {
    @GET("sites/MLM/search")
    suspend fun searchItem(@Query("q") q: String):Response

    @GET("items")
    suspend fun getItem(@Query("ids") ids:String):ArrayList<ResponseDetailProduct>

    @GET("items/{ids}/description")
    suspend fun getItemDescription(@Path("ids")ids:String): ResponseDescriptionProduct
}