package com.smkcoding.smkcodingchalleng2.data_donor_darah

public class Model{
    lateinit var alamat:String
    lateinit var instansi:String
    lateinit var jam:String

    constructor(id: String,name:String,email:String) {
        this.alamat = id
        this.instansi = name
        this.jam = email
    }

    constructor()
}