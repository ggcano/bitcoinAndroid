package com.example.student.services.dto

import com.google.gson.annotations.SerializedName

data class BpiDTO(

    @SerializedName("USD")
    val usd: Coin,

    @SerializedName("GBP")
    val gpb: Coin,

    @SerializedName("EUR")
    val eur: Coin
)