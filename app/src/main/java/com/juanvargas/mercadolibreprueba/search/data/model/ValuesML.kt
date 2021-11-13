package com.juanvargas.mercadolibreprueba.search.data.model

import com.google.gson.annotations.SerializedName

data class ValuesML (
    val id:String,
    val name:String,
    @SerializedName("path_from_root")
    val pathFromRoot:ArrayList<ValuesML>?,
    val results:ArrayList<ValuesML>?
    )