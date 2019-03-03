package com.blank.pickpic.di

import com.blank.pickpic.api.UpsplashAPI
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

val apiModule = Kodein.Module("api_module") {

    bind<UpsplashAPI>("upsplash_api") with singleton {
        instance<Retrofit.Builder>("retrofit_builder")
            .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
            .build().create(UpsplashAPI::class.java)
    }
}