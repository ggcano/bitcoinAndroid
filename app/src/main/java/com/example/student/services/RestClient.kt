package com.example.student.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestClient {
    private val TAG = "Network"
    val CONNECT_TIMEOUT = 20000
    val WRITE_TIMEOUT = 20000
    val READ_TIMEOUT = 20000

    lateinit var apiGetService: ApiGetService
    private val baseUrl = "https://api.coindesk.com/v1/"

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)

        val interceptor =  HttpLoggingInterceptor()
        interceptor.level = (HttpLoggingInterceptor.Level.BODY)
        val client = okHttpClient.addInterceptor(interceptor).build()


        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        initServices(retrofit)
    }

    fun getApiService(): ApiGetService {
        return apiGetService
    }

    fun initServices (retrofit: Retrofit){
        apiGetService = retrofit.create(ApiGetService::class.java)
    }

}