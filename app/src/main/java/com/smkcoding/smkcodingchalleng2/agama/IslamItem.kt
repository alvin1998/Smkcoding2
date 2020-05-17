package com.smkcoding.smkcodingchalleng2.agama


import com.google.gson.annotations.SerializedName

data class IslamItem(
    @SerializedName("arti")
    val arti: String,
    @SerializedName("asma")
    val asma: String,
    @SerializedName("audio")
    val audio: String,
    @SerializedName("ayat")
    val ayat: Int,
    @SerializedName("keterangan")
    val keterangan: String,
    @SerializedName("nama")
    val nama: String,
    @SerializedName("nomor")
    val nomor: String,
    @SerializedName("rukuk")
    val rukuk: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("urut")
    val urut: String
)