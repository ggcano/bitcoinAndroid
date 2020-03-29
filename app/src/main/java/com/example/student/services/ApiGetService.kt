package com.example.student.services

import com.example.student.services.dto.ApiDto
import retrofit2.Call
import retrofit2.http.GET

interface ApiGetService {

    @GET("bpi/currentprice.json")
    fun getApi (): Call<ApiDto>

}