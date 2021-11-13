package com.juanvargas.mercadolibreprueba.search.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PictureML (
    var id:String,
    var url:String,
    @SerializedName("secure_url")
    var secureUrl:String,
    var size:String,
    var max_size:String,
    var quality:String
) : Parcelable