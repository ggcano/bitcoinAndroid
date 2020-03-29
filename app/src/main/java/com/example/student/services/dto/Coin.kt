package com.example.student.services.dto

import com.google.gson.annotations.SerializedName

data class Coin(

    @SerializedName("code")
    val codeDTO: String,

    @SerializedName("symbol")
    val symbolDTO: String,

    @SerializedName("rate")
    val rateDTO: String,

    @SerializedName("description")
    val descriptionDTO: String,

    @SerializedName("rate_float")
    val rateFloatDTO: Float

)



