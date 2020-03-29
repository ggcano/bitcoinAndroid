package com.example.student

import androidx.lifecycle.MutableLiveData
import com.example.student.services.RestClient
import com.example.student.services.dto.ApiDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Repo {

    private val restClient: RestClient = RestClient()

    fun getBitCoinFromApi(): MutableLiveData<ApiDto> {
        val mutableBitCoinData: MutableLiveData<ApiDto> = MutableLiveData()
        val call = restClient.getApiService().getApi()

        call.enqueue(object : Callback<ApiDto> {
            override fun onFailure(call: Call<ApiDto>, t: Throwable) {

                t.printStackTrace()
            }

            override fun onResponse(call: Call<ApiDto>, response: Response<ApiDto>) {
                mutableBitCoinData.value = response.body()
            }

        })

        return mutableBitCoinData
    }

}
