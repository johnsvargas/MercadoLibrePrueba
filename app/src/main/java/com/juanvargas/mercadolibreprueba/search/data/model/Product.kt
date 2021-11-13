package com.juanvargas.mercadolibreprueba.search.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product (
    val id:String,
    @SerializedName("site_id")
    val siteId:String,
    val title:String,
    val price:Double,
    val sale_price:Double,
    val thumbnail:String,
    val pictures:ArrayList<PictureML>,
    val attributes:ArrayList<AttributesML>,
    val warranty:String,
    val condition:String,
    @SerializedName("available_quantity")
    val availableQuantity:Int,
    @SerializedName("sold_quantity")
    val soldQuantity:Int
) : Parcelable