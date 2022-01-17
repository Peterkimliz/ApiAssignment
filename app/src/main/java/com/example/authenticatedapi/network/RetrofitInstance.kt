package com.example.authenticatedapi.network

import com.example.authenticatedapi.utils.Constants.Companion.BASE_URL
import com.example.authenticatedapi.utils.Constants.Companion.TOKEN
import com.example.authenticatedapi.views.ServiceInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {
        val retrofit by lazy {
               val client = OkHttpClient.Builder()
                .addInterceptor(ServiceInterceptor())
                .build()

            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api by lazy {
            retrofit.create(Api::class.java)

        }


    }
}