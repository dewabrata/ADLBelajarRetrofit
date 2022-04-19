package com.adl.belajarretrofit.services

import com.adl.belajarretrofit.model.OMDBResponse
import retrofit2.Call
import retrofit2.http.GET

interface IMovieDetail {

    @GET("?t=titan&apikey=80641bfb")
    fun getDetailMovie(): Call<OMDBResponse>
}