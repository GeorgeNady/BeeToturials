package com.george.beetoturials.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class ApiClient {

    companion object {

        private const val BASE_URL = "https://hosha.beeinteractivemedia.com/api/"

        private val retrofit by lazy {

            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .addInterceptor { chain: Interceptor.Chain ->
                    val original = chain.request()
                    val request =
                        original.newBuilder() // .header("Accept-Language", Preferences.getInstance().getApplicationLanguage())
                            .addHeader("Accept", "application/json")
                            .addHeader("Content-Type", "application/json")
                            .method(original.method(), original.body())
                            .build()
                    chain.proceed(request)
                }
                .build()

            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        val api: ApiInterface by lazy {
            retrofit.create(ApiInterface::class.java)
        }

    }

}