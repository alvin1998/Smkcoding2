package com.smkcoding.smkcodingchalleng2.data_covid


import com.google.gson.annotations.SerializedName

data class CovidItem(
    @SerializedName("attributes")
    val attributes: Attributes
)