package com.juanvargas.mercadolibreprueba.search.data.model

import com.google.gson.annotations.SerializedName

data class Response (
    val site_id:String,
    @SerializedName("country_default_time_zone")
    val countryDefaultTimeZone:String,
    val query: String,
    val paging:Paging,
    val results:ArrayList<Product>,
    val sort:ValuesML,
    @SerializedName("available_sorts")
    val availableSorts:ArrayList<ValuesML>,
    val filters:ArrayList<Filters>,
    @SerializedName("available_filters")
    val availableFilters:ArrayList<ValuesML>,
        )
