package com.juanvargas.mercadolibreprueba.util

import com.juanvargas.mercadolibreprueba.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object NetworkClient {

    //https://api.mercadolibre.com/sites/MLM/search?q=xiaomi#options

    fun buildRetrofitClient(): Retrofit {

        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttpClient())
            .baseUrl("https://api.mercadolibre.com/")
            .build()
    }

    private fun buildOkHttpLoggerInterceptor(): Interceptor {
        return HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) {
                level = HttpLoggingInterceptor.Level.HEADERS
                level = HttpLoggingInterceptor.Level.BODY
            }
        }
    }


    private fun okhttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(buildOkHttpLoggerInterceptor())
        }.build()
    }

}
