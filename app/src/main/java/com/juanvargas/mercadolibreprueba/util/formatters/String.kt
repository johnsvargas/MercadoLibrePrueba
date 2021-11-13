@file:JvmName("FormattersString")
package com.juanvargas.mercadolibreprueba.util.formatters

fun String.setCondition(): String {
    return when(this){
        "new"-> "Nuevo"
        "used"-> "Usado"
        else->"No especificado"
    }
}