package com.smkcoding.smkcodingchalleng2.data
import com.smkcoding.smkcodingchalleng2.*
import com.smkcoding.smkcodingchalleng2.agama.IslamItem
import com.smkcoding.smkcodingchalleng2.data_covid.Attributes
import com.smkcoding.smkcodingchalleng2.data_covid.CovidItem
import com.smkcoding.smkcodingchalleng2.data_donor_darah.Darah
import com.smkcoding.smkcodingchalleng2.data_donor_darah.Data


import retrofit2.Call
import retrofit2.http.GET

interface GithubService {
    @GET("users")
    fun getUsers(): Call<List<GithubUserItem>>
}

interface Getislam {
    @GET("data.json")
    fun getislam(): Call<List<IslamItem>>
}
interface GetCovid {
    @GET("provinsi")
    fun getcovid(): Call<List<CovidItem>>
}
interface GetDarah {
    @GET("echo?user_content_key=6ME5x4XXqScD_Tbzfh-LJFXeOWngFtoS2uR6IJadCKIXJoZbg5ilF7fqMg_AvmXfgjCUuBelmJ4Em6vObIJW5ZBH3z9TipREOJmA1Yb3SEsKFZqtv3DaNYcMrmhZHmUMWojr9NvTBuB6lHT6qnqYcmFWggwoSVQQXTsQ1HqKa1CgDXQROm1OeNR5ibYVAaRxAeOtzLmbRZcVjrce7Uveb8iU1s-L39A_CLDTUaq6azCNVhRMhi1rsDKfemnxd2fexfjRk53QbyB9dvgI2LNPjQO3wTJi0CM9&lib=M-tpZm-Fm1QX9Yr80nZn_p-WXe3zpGnIr")
    fun getDarah(): Call<Darah>
}

