package com.blank.pickpic.api

import retrofit2.http.GET


interface UpsplashAPI {

    @GET("collections/feature")
    fun getFeaturedCollections(page: Int = 1, perPage: Int = 10)

}