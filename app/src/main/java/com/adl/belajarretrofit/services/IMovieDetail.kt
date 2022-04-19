package com.adl.belajarretrofit.services

import com.adl.belajarretrofit.model.OMDBResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IMovieDetail {

    @GET("?apikey=80641bfb")
    fun getDetailMovie(
        @Query("t" ) query:String   ): Call<OMDBResponse>
}