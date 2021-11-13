package com.juanvargas.mercadolibreprueba.detailproduct.data.model

import com.google.gson.annotations.SerializedName

data class ResponseDescriptionProduct(
    val text:String,
    @SerializedName("plain_text")
    val plainText:String,
    @SerializedName("last_updated")
    val lastUpdated:String,
    @SerializedName("date_created")
    val dateCreated:String
)
