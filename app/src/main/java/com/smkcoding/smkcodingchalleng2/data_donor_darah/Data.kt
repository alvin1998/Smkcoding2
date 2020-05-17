package com.smkcoding.smkcodingchalleng2.data_donor_darah


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("alamat")
    val alamat: String,
    @SerializedName("instansi")
    val instansi: String,
    @SerializedName("jam")
    val jam: String,
    @SerializedName("rencana_donor")
    val rencanaDonor: String
)