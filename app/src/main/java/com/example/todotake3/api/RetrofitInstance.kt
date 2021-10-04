package com.example.todotake3.api

import com.example.todotake3.utils.Constants.Companion.BASE_URL
import com.example.todotake3.utils.Constants.Companion.TIMEOUT
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
//
object RetrofitInstance {

    private fun providesOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor =
            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
                .setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder().connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
            .client(providesOkHttpClient())
            .build()
    }
}

//class RetrofitInstance {
//    companion object {
//
//        private val retrofit by lazy {
//            val logging = HttpLoggingInterceptor()
//            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
//
//            val client = OkHttpClient.Builder()
//                .addInterceptor(logging)
//                .build()
//
//            Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(client)
//                .build()
//        }
//
//        val api by lazy {
//            retrofit.create(TodoService::class.java)
//        }
//    }
//}