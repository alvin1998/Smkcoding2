package com.smkcoding.smkcodingchalleng2.data
import com.smkcoding.smkcodingchalleng2.*

import retrofit2.Call
import retrofit2.http.GET

interface GithubService {
    @GET("users")
    fun getUsers(): Call<List<GithubUserItem>>
}
//interface GetHome {
//
//    @GET("api")
//    fun getHome(): Call<List<Home>>
//}
