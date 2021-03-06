package com.blank.pickpic.di

import android.os.Bundle
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

val networkModule = Kodein.Module("network_module") {

    bind<String>("upsplash_key") with singleton {
        instance<Bundle>("meta-data").getString("key_upsplash")
    }

    bind<Interceptor>("query_interceptor") with singleton {
        Interceptor { chain ->
            var request: Request = chain.request()
            val queryAddedUrl: HttpUrl = request.url().newBuilder()
                .addQueryParameter("client_id", instance<String>("upsplash_key"))
                .build()
            request = request.newBuilder().url(queryAddedUrl).build()
            chain.proceed(request)
        }
    }

    bind<HttpLoggingInterceptor>("http_logging_interceptor") with singleton {
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    bind<OkHttpClient>("http_client") with singleton {
        OkHttpClient.Builder()
            .addInterceptor(instance<Interceptor>("query_interceptor"))
            .addInterceptor(instance<HttpLoggingInterceptor>("http_logging_interceptor"))
            .build()
    }

    bind<Retrofit.Builder>("retrofit_builder") with singleton {
        Retrofit.Builder()
            .client(instance<OkHttpClient>("http_client"))
            .baseUrl("https://api.unsplash.com/")
    }

    bind<Retrofit>() with singleton {
        instance<Retrofit.Builder>("retrofit_builder")
            .addConverterFactory(Json.nonstrict.asConverterFactory(MediaType.get("application/json")))
            .build()
    }

}
