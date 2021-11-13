@file:JvmName("FormattersDouble")
package com.juanvargas.mercadolibreprueba.util.formatters

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

fun Double.formatPriceNoDecimals(): String {
    val df = DecimalFormat("#,###.##", DecimalFormatSymbols(Locale.US))
    return "$%s".format(df.format(this.toInt()))
}