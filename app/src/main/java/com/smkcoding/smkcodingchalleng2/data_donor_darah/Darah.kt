package com.smkcoding.smkcodingchalleng2.data_donor_darah


import com.google.gson.annotations.SerializedName

data class Darah(
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("status")
    val status: String
)