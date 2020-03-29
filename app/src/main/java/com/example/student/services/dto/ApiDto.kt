package com.example.student.services.dto

import com.google.gson.annotations.SerializedName

data class ApiDto (

    @SerializedName("time")
    val time: TimeDTO,

    @SerializedName("disclaimer")
    val disclamer: String,

    @SerializedName("chartName")
    val chartName: String,

    @SerializedName("bpi")
    val bpi: BpiDTO

)
