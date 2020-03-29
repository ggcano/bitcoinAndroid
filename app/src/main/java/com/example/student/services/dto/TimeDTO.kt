package com.example.student.services.dto

import com.google.gson.annotations.SerializedName

data class TimeDTO(

    @SerializedName("updated")
    val update: String,

    @SerializedName("updateduk")
    val updatedUk: String,

    @SerializedName("updatedISO")
    val updatedISO: String

)