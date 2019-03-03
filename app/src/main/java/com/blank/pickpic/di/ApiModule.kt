package com.blank.pickpic.di

import com.blank.pickpic.services.UpsplashService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

val apiModule = Kodein.Module("api_module") {

    bind<UpsplashService>() with singleton {
        instance<Retrofit>().create(UpsplashService::class.java)
    }
}