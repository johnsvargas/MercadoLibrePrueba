package com.juanvargas.mercadolibreprueba.search.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AttributesML (
        var id:String,
        var name:String,
        @SerializedName("value_id")
        var valueId:String,
        var value_name:String
) : Parcelable