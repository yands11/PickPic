package com.blank.pickpic.services

import com.blank.pickpic.data.Photo
import io.reactivex.Single
import retrofit2.http.GET


interface UpsplashService {

    @GET("photos")
    fun getPhotos(
        page: Int = 1,
        perPage: Int = 20
    ): Single<List<Photo>>

}