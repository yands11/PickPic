package com.blank.pickpic.services

import com.blank.pickpic.data.Photo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface UpsplashService {

    @GET("photos")
    fun getPhotos(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 20
    ): Call<List<Photo>>

}