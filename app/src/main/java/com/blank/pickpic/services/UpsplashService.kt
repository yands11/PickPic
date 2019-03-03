package com.blank.pickpic.services

import retrofit2.http.GET


interface UpsplashService {

    @GET("collections/feature")
    fun getFeaturedCollections(page: Int = 1, perPage: Int = 10)

}